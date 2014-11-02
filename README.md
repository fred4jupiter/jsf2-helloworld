jsf2-helloworld
===============

Small demo application with JSF 2 used for a continous delivery demo pipeline.

For running in docker:

Build container with 

    sudo docker build -t mstaehler/jsf2helloworld .

After that start container like so

    sudo docker run -d -p 46160:8080 -e spring.profiles.active=test mstaehler/jsf2helloworld

Open the app in browser

[http://localhost:46160/jsf2-helloworld/faces/pages/hello.xhtml](http://localhost:46160/jsf2-helloworld/faces/pages/hello.xhtml "http://localhost:46160/jsf2-helloworld/faces/pages/hello.xhtml")


