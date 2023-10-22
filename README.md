setting up a CICD pipeline using jenkins and Docker. The application is already dockerized
and we are yet to push it to docker hub.

1. create a jenkins job of type pipeline with the name cryptit-pipeline01
 
2. But before we create this pipeline we have to setup github web hook.
   We can do this by navigating to the repo of our project and clicking on the settings.    
    select the webhook icon and pass in the nameof your jenkins url like this:
                https://github.com/marviigrey/cryptit/settings/hooks/
    Ensure you give permission to docker.   
