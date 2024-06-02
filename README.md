# Spring-config
Spring Configurations

Annotation Used
@Value: In this we can define the exact property key defined in application.properties/yaml file For example: In application.properties, we have property as author.name = Paras Arora. We can directly used this annotation on top of field - @Value(${author.name})
Spring will bind and inject the value in field.

@ConfigurationProperties: This annotation is used to let spring bind properties to DTO.
This is used with @Component so that it is treated as Spring Bean.
If No @PropertySource is mentioned, it will bind the properties only from application.properties

@PropertySource: This annotation is used, if our properties are not in default property file i.e. application.properties and the properties are defined in some other property file. @PropertySource is used in combination to @ConfigurationProperties

#SPRING-CLOUD CONFIG SERVER
Spring Cloud Config Server is required when we want to externalize the configuration and make it centralized.

1. To enable Config Server, Add a dependency of "spring-cloud-config-server" in pom.xml
2. Add annotation of @EnableConfigServer on top of main class.
3. Add Properties in application.properties to let Spring know the GIT location
*Example:
	spring.cloud.config.server.git.uri = https://github.com/paras285/spring-config-configurations.git

#SPRING-CLOUD CONFIG CLIENT
Spring Cloud Config Client enables the Spring to fetch the configurations from Spring Cloud Config Server.

To enable Spring Cloud Config Client
1. Add a dependency of "spring-cloud-starter-config" in pom.xml of application which needs to connect to Spring Config Server.
2. Add properties to let Spring know about Config Server location and file name.
*Example:
	spring.config.import=configserver:http://localhost:8081
	spring.cloud.config.name=configurations

Make sure the file is present in GIT location with name configuration.properties or configuration.yml

#Scenarios
*Scenario-1 If the key is present in Config Server and project locally
Preference will be given to Config Server i.e., If key is preset in Config Server.
Else, Spring will try to fetch the properties locally.

If key is not available in both the location, application will fail.

*Scenario-2 If the key is present in project locally only
It will fetch the key only from properties locally.

If the key is not available in project locally, application will fail.

*Scenario-2 If the key is not present in Config Server and Project
Application will fail directly
