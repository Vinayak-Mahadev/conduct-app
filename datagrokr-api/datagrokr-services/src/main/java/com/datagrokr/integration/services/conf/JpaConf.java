package com.datagrokr.integration.services.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.RepositoryException;

/**
 * <b>Purpose:</b>
 * <br>
 * <br>
 * 
 * <b>DesignReference:</b><br>
 * <br>
 * <br>
 * 
 * <b>CopyRights:</b><br>
 * Enhancesys Innovations Private Limited<br>
 * <br>
 * 
 * <b>RevisionHistory:</b>
 * 
 * <pre>
 * <b>
 * Sl No   Modified Date		Author</b>
 * ==============================================
 * 1       Mar 2, 2020			Vinayak Mahadev
 * 	-- Base Release
 * </pre>
 * 
 * <br>
 */

@Configuration
@ComponentScan({"com.datagrokr"})
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EntityScan({"com.datagrokr.integration.services.entities"})
@EnableJpaRepositories(basePackages = {"com.datagrokr.integration.services.repo"})
public class JpaConf 
{
	@Autowired
	Environment ENV;

	private final String DRIVER = "spring.datasource.driverClassName";
	private final String USER = "spring.datasource.username";
	private final String PASS = "spring.datasource.password";
	private final String URL = "spring.datasource.url";
	private final String TIMEOUT = "spring.datasource.timout";
	
	private JDBCDataSource jdbcDataSource;
	
	@Bean
	protected JDBCDataSource getJDBCDataSource()
	{
		if(jdbcDataSource == null)
			jdbcDataSource = new JDBCDataSource(ENV.getProperty(DRIVER), ENV.getProperty(URL), ENV.getProperty(USER), ENV.getProperty(PASS), ENV.getProperty(TIMEOUT));
		return jdbcDataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() throws SQLException
	{
		return new JdbcTemplate(getJDBCDataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws SQLException
	{
		return new NamedParameterJdbcTemplate(getJDBCDataSource());
	}
	
	public static class JDBCDataSource extends DriverManagerDataSource
	{
		private static Logger log = LoggerFactory.getLogger(JDBCDataSource.class);
		
		private String driverClassName;
		private String url;
		private String username;
		private String password;
		private String socketTimeout;
		
		public JDBCDataSource(String driverClassName, String url, String username, String password, String socketTimeout)
		{
			super();
			init(driverClassName, url, username, password, socketTimeout);
		}
		
		public Connection getDBConnection() throws RepositoryException
		{
			Connection connection = null;
			Properties properties = null;

			try
			{
				properties = new Properties();
				properties.setProperty("user", username);
				properties.setProperty("password", password);
				if(socketTimeout != null && !socketTimeout.trim().isEmpty())
					properties.setProperty("socketTimeout", socketTimeout);
				Class.forName(driverClassName);
				connection = DriverManager.getConnection(url, properties);
				return connection;
			}
			catch(Exception exception)
			{
				log.error(exception.getMessage(), exception);
				throw new RepositoryException(DataConstants.DB_CONNECTION_ERROR_CODE , exception.getMessage(), exception);
			}
			finally
			{
				connection = null;
				properties = null;
			}
		}
		
		public void init(String driverClassName, String url, String username, String password, String socketTimeout) 
		{
			Properties connectionProperties = null;
			try
			{
				setDriverClassName(driverClassName);
				setUrl(url);
				setUsername(username);
				setPassword(password);
				connectionProperties = new Properties();
				connectionProperties.setProperty("socketTimeout", socketTimeout);
				setConnectionProperties(connectionProperties);
			}
			catch(Exception exception)
			{
				log.error(exception.getMessage(), exception);
			}
		}
	}

}
