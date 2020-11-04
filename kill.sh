docker rm $(docker stop $(docker ps -a -q -f name=primary-db))
docker rm $(docker stop $(docker ps -a -q -f name=failover-db))