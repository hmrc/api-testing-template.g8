#!/bin/bash

# SETUP
start_mongo_container() {
  echo "starting Mongo container"
  if docker ps | grep "mongo"; then
    echo "Mongo container is already running"
  else
    docker run --rm -d --name mongo -p 27017:27017 mongo:3.6
    echo "Mongo container started"
  fi

}

## Services
start_mongo_container
sm --start PAYMENTS_DIRECT_DEBIT -f

# Test 1 - local, cucumber
g8 file://api-testing-template.g8/ --name=test-1
cd test-1 || exit
sbt clean test
cd - || exit
rm -rf test-1

# TEAR DOWN
sm --stop PAYMENTS_DIRECT_DEBIT
docker stop mongo
