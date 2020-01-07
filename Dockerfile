FROM openjdk:8-alpine
ENV APP_NAME books-1.0-SNAPSHOT.jar
#COPY ./target/${APP_NAME} /usr/src/app/${APP_NAME}
COPY ./target/books-1.0-SNAPSHOT.jar /usr/src/app/books-1.0-SNAPSHOT.jar
WORKDIR /usr/src/app
#RUN javac Main.java
#RUN mvn clean compile package install
EXPOSE 9090
#CMD ["java", "-jar", "${APP_NAME}"]
CMD ["java", "-jar", "books-1.0-SNAPSHOT.jar"]