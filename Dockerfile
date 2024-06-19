FROM ghcr.io/graalvm/jdk-community:17
EXPOSE 8081
ADD build/libs/epictravelassistant-0.0.1-SNAPSHOT.jar epictravelassistant.jar
ENTRYPOINT ["java","-jar","-Xms256M","-Xmx8096M","epictravelassistant.jar"]