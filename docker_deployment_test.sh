#!/bin/bash

docker build -t mstaehler/jsf2-helloworld .
docker stop hello_test
docker rm hello_test
docker tag mstaehler/jsf2-helloworld localhost:5000/mstaehler/jsf2-helloworld
docker push localhost:5000/mstaehler/jsf2-helloworld
docker run -d --name hello_test -p 49160:8080 -e spring.profiles.active=test -t localhost:5000/mstaehler/jsf2-helloworld 
