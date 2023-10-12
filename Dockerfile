FROM adoptopenjdk:17-jdk-hotspot
COPY build/libs/erp-backend-app-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
