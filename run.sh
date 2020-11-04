docker-compose -f docker-stack.yml up &

sleep 15 #Might need to change depending on system, or just start Java application separately

java -jar target/postgres-datasource-failover-0.0.1-SNAPSHOT.jar