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

To enable Config Server, Add a dependency of "spring-cloud-config-server" in pom.xml
Add annotation of @EnableConfigServer on top of main class.
Add Properties in application.properties to let Spring know the GIT location
*Example:
spring.cloud.config.server.git.uri = https://github.com/paras285/spring-config-configurations.git