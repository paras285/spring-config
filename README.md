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

Scenarios

Scenario-1 If the key is present in Config Server and project locally
Preference will be given to Config Server i.e., If key is preset in Config Server.
Else, Spring will try to fetch the properties locally.

If key is not available in both the location, application will fail.

Scenario-2 If the key is present in project locally only
It will fetch the key only from properties locally.

If the key is not available in project locally, application will fail.

Scenario-2 If the key is not present in Config Server and Project
Application will fail directly

#ENCRYPTION AND DECRYPTION IN CONFIG SERVER
Config Server supports symmetrical and asymmetrical encryption/decryption
It exposes 2 end-points
/encrypt - To encrypt the key provided in the body
/decrypt - To decrypt the key provided in the body

<Encrypted_Key> fetched from /encrypt response is then used in Configurations
Example:
KEY = {cipher}<Encrypted_Key>

#SYMMETRIAL ENCRYPTION/DECRYPTION IN CONFIG SERVER
To support symmetrical encryption, add the following key in applcation.properties/application.yml of Config Server

encrypt.key = <SECRET_KEY>

Now, when any value needs to be bind, it will be responsibility of Spring Config Server to decrypt the value and bind it to field.
Alternatively, /decrypt can be used to decrypt and see the value.


#CONTAINERIZATION OF THESE SERVICES
Creation of a docker image image from Docker File.

docker build -t <ImageName:Version> .
This will create a docker file from the given location with specified tag

Example: 
docker build -t configurations:latest .
docker build -t config-server:latest .

Creating a container from the docker image

docker run --name <Container_Name> -p <HostAddress:ContainerHost> --network <CustomNetwork> <ImageName>

Example:
docker run --name configuration -p 8080:8080 --network default_network configurations:latest

NOTE: Make sure the both servers are on same network so that they can communicate with each other using container name.

#Profiling
We can create the different applications propties w.r.t properties.
The applications will be retrieved from the specific property file.

Example:
If dev profile is active, and Application name is configurations.
There needs to be file present in configurations-dev.properties (ApplicationName-{profile}.properties)

During Startup time, We can provide the profile that we are going to use.

Normal JAR Execution
java -jar -D spring.profiles.active=profile1,profile2 applicationName.jar

Creation of Docker Image 
CMD ["java","-jar","-D spring.profiles.active=profile1,profile2,"config-server.jar"]

Docker Image
docker run -e SPRING_PROFILES_ACTIVE=dev -p 8080:8080 --name containerName imageName:version

Docker Compose file
![image](https://github.com/paras285/spring-config/assets/57625232/141951e0-c84d-4163-bb87-25b307873625)
