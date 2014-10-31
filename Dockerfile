# DOCKER-VERSION 1.2.0

FROM tutum/tomcat

MAINTAINER Michael Staehler <hamsterhase@gmx.de>

COPY target/jsf2-helloworld.war ${CATALINA_HOME}/webapps/jsf2-helloworld.war