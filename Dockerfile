FROM amazoncorretto:17

VOLUME /tmp
COPY backend/target/*.jar app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]