#!/bin/bash

# running your local registry
# sudo docker run -p 5000:5000 -d registry

sudo docker build -t mstaehler/jsf2-helloworld .
sudo docker stop hello_test
sudo docker rm hello_test
sudo docker tag mstaehler/jsf2-helloworld localhost:5000/mstaehler/jsf2-helloworld
sudo docker push localhost:5000/mstaehler/jsf2-helloworld
sudo docker run -d --name hello_test -p 49160:8080 -e spring.profiles.active=test -t localhost:5000/mstaehler/jsf2-helloworld 
