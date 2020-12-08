FROM openjdk:11-jdk
VOLUME /tmp
COPY target/*.jar app.jar
COPY keystore/valuableAuto.keystore valuableAuto.keystore
ENTRYPOINT ["java","-jar","/app.jar"]
