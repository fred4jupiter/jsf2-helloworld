#!/bin/bash

# running your local registry
# sudo docker run -p 5000:5000 -d registry

# NOTE: Run this script as sudo: sudo docker_deployment_test.sh

# For running sudo from jenkins user you have to edit /etc/sudoers
#    sudo nano /etc/sudoers
# add following line at the end:
#    jenkins ALL= NOPASSWD: ALL

docker stop hello_prod
docker rm hello_prod
docker pull localhost:5000/mstaehler/jsf2-helloworld
docker run -d --name hello_prod -p 49161:8080 -e spring.profiles.active=prod -t localhost:5000/mstaehler/jsf2-helloworld
