
from openjdk:latest
WORKDIR /app

copy target/APi-0.0.1-SNAPSHOT.jar  ExequielCabrera.jar
EXPOSE 8080



entrypoint ["java", "-jar","ExequielCabrera.jar"]
