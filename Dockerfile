FROM openjdk:20
EXPOSE: 8080
ADD target/newstrackerapp.jar newstrackerapp.jar
ENTRYPOINT ["java"."-jar","/newstrackerapp.jar"]