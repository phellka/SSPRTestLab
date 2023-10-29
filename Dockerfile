FROM openjdk:17-oracle

ADD build/libs/IPlabs-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "-Dspring.profiles.active=dev", "/app/IPlabs-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080