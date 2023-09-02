FROM openjdk:17
EXPOSE 8081
ADD target/Spring-Email-service-0.0.1-SNAPSHOT.jar Spring-Email-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","Spring-Email-service-0.0.1-SNAPSHOT.jar" ]