FROM adoptopenjdk:8-jre-hotspot

COPY target/postgres-datasource-failover-0.0.1-SNAPSHOT.jar / 

CMD ["java", "-jar", "postgres-datasource-failover-0.0.1-SNAPSHOT.jar"]