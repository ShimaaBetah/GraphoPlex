## FROM Ubuntu 20.04
FROM ubuntu:20.04
## install jdk 17
RUN apt-get update && apt-get install -y openjdk-17-jdk
## add redis server
RUN apt-get update && apt-get install -y redis
## start redis server using cmd
EXPOSE 8080
EXPOSE 9090
ADD target/graph-db-server.jar graph-db-server.jar

ADD entrypoint.sh entrypoint.sh

## set entry point to entrypoint.sh
ENTRYPOINT ["sh", "/entrypoint.sh"]


##ENTRYPOINT ["java", "-jar", "/graph-db-server.jar"]
