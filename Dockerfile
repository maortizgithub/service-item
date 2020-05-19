FROM openjdk:14
VOLUME /tmp
EXPOSE 8002
ADD ./target/service-item-0.0.1-SNAPSHOT.jar service-item.jar
ENTRYPOINT ["java", "-jar", "/service-item.jar"]