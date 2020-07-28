FROM openjdk:11.0.5
RUN mkdir app
ADD target/SBRestDemo-0.0.1-SNAPSHOT.jar app/SBRestDemo.jar
WORKDIR app
ENTRYPOINT ["java","-jar","app.jar"]
Expose 8080