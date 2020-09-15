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

initialize_repo() {
  #The repo uses sbtAutoBuildPlugin which requires repository.yaml, licence.txt and an initial git local commit to compile
  cp $WORKSPACE/api-testing-template.g8/repository.yaml .
  cp $WORKSPACE/api-testing-template.g8/LICENSE .
  git init
  git add .
  git commit -m "initial commit"
}

## Services
start_mongo_container
sm --start DIRECT_DEBIT_STUBS -r

# Test 1 - local, cucumber
g8 file://api-testing-template.g8/ --name=test-1
cd test-1 || exit
initialize_repo
sbt clean test
cd - || exit
rm -rf test-1

# TEAR DOWN
sm --stop DIRECT_DEBIT_STUBS
docker stop mongo
