FROM maven:3.8.1-jdk-8 AS build
RUN mkdir -p /home/appuser
WORKDIR /home/appuser
COPY pom.xml /home/appuser
COPY datagrokr-common /home/appuser/datagrokr-common
COPY datagrokr-services /home/appuser/datagrokr-services
RUN mvn -f pom.xml clean install

FROM openjdk:8-alpine
COPY --from=build /home/appuser/datagrokr-services/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
