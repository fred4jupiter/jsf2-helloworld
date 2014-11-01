#!/bin/bash

docker stop hello_prod
docker rm hello_prod
docker pull localhost:5000/mstaehler/jsf2-helloworld
docker run -d --name hello_prod -p 49161:8080 -e spring.profiles.active=prod -t localhost:5000/mstaehler/jsf2-helloworld
