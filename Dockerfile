FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/student-diary-0.0.1-SNAPSHOT.jar diary.jar
ENTRYPOINT ["java","-jar","/diary.jar"]