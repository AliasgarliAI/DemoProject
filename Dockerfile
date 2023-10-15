FROM openjdk:22-oracle
COPY build/libs/erp-backend-app-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/erp-backend-app-0.0.1-SNAPSHOT.jar"]
