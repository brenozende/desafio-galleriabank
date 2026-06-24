FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# instala git (necessário para clone)
RUN apt-get update && apt-get install -y git

# clone do repo
ARG REPO_URL
RUN git clone ${REPO_URL} .

# build
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]