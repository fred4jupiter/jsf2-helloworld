Prerequisites for running the deploymen script with Docker in Jenkins
===============

Before you start be sure that you have started the private docker registry

	sudo docker run -p 5000:5000 -d registry

NOTE: This does work until Docker version 1.2. With Docker 1.3.x upwords you have to use ssh keys or start the Docker daemon with the `--insecure-registry` flag. For using the insecure flag you have to edit the file `/etc/default/docker` and add the entry `DOCKER_OPTS="--insecure-registry localhost:5000"`.

The deployment script has to be run as sudo:

	sudo ./docker_deployment_test.sh

For running sudo from the jenkins user the sudo permission has to be added in the `/etc/sudoers` file. Add the following line by opening the file with `sudo visudo`:

	jenkins ALL= NOPASSWD: ALL