# Spring-config
Spring Configurations

Annotation Used
@Value: In this we can define the exact property key defined in application.properties/yaml file For example: In application.properties, we have property as author.name = Paras Arora. We can directly used this annotation on top of field - @Value(${author.name})
Spring will bind and inject the value in field.
