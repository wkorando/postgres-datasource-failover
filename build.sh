docker build -f Postgres-Dockerfile-primary -t primary-db .
docker build -f PPostgres-Dockerfile-failover -t failover-db .

./mvnw clean package