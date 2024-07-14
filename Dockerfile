FROM openjdk:17-oracle

WORKDIR /app

COPY pom.xml .

RUN ./mvnw clean install

COPY . .