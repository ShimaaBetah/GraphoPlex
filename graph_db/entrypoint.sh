#! usr/bin/bash
/bin/redis-server --port ${REDIS_PORT} & java -jar /graph-db-server.jar