setting up a CICD pipeline using jenkins and Docker. The application is already dockerized
and we are yet to push it to docker hub.

1. create a jenkins job of type pipeline with the name cryptit-pipeline01
 
2. But before we create this pipeline we have to setup github web hook.
   We can do this by navigating to the repo of our project and clicking on the settings.    
    select the webhook icon and pass in the nameof your jenkins url like this:
                https://github.com/marviigrey/cryptit/settings/hooks/
    in our build trigger, select a poll scm settings.
    Ensure you give permission to docker using: sudo chmod 777 /var/run/docker.sock
    on your vm where docker and jenkins is installed.

3. create a secured credentialsId for jenkins to have access to your dockerhub where we will be pushing
    the image to after creating the image. go to manage jenkins>credentials>system
    select a global unrestricted credentials>add-credentials for your dockerhub username and password.

4.the pipeline for this job is the file.groovy on this repo.
