package com.datagrokr.integration.services.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonRootName(value = "conduct")
@Entity
@Table(name = "tr_conducts")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Conduct implements Serializable 
{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_n", nullable=false, columnDefinition = "serial")
    @NonNull
    protected Long id;

    @Column(name="name_v", nullable=false)
    @NonNull
    protected String name;

    @Column(name="first_name_v", nullable=true)
    protected String firstName;

    @Column(name="last_name_v", nullable=true)
    protected String lastName;

    @Column(name="email_id_v", nullable=false)
    @NonNull
    protected String emailId;

    @Column(name="phone_number_n", nullable=false)
    @NonNull
    protected Long phoneNumber;

	@Column(name="city_v", nullable=true)
	protected String city;

	@Column(name="state_v", nullable=true)
	protected String state;

	@Column(name="country_v", nullable=true)
	protected String country;

	@Column(name="pincode_n", nullable=true)
	protected Long pincode;
	
	@Column(name="created_time_dt", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	protected Date createdTime;

	@Column(name="last_updated_time_dt", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	protected Date lastUpdatedTime;

	@JsonGetter("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonGetter("firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonGetter("lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonGetter("emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@JsonGetter("phoneNumber")
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonGetter("city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonGetter("state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonGetter("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonGetter("pincode")
	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@JsonGetter("createdTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	} 
	
	@JsonGetter("lastUpdatedTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	} 
}
