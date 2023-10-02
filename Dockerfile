FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/spring-starter-0.0.1-SNAPSHOT.jar spring-starter.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-starter.jar", "spring_profiles_active=prod",
"PGHOST=postgres://admin:qO3W6G107bXYnimKMkQt82zeUJwDau0x@dpg-ckderr5jhfbs73air1bg-a.oregon-postgres.render.com/someone",
"PGPORT=5432",
"PGDATABASE=someone",
"PGUSER=admin",
"PGPASSWORD=qO3W6G107bXYnimKMkQt82zeUJwDau0x"
]