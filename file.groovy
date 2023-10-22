pipeline {
    agent any
    stages {
        stage("code checkout") {
            steps {
                git 'https://github.com/marviigrey/cryptit'
            }
        }
        stage("image build") {
            steps {
                script {
                    sh "docker build -t marviigrey/cryptit:v${BUILD_ID} ."
                    sh "docker image tag marviigrey/cryptit:v${BUILD_ID} marviigrey/cryptit:latest"
                }
            }
        }
        stage("push to dockerhub") {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    sh "docker login -u ${user} -p ${pass}"
                    sh "docker image push marviigrey/cryptit:v${BUILD_ID}"
                    sh "docker image push marviigrey/cryptit:latest"
                    sh "docker image rmi marviigrey/cryptit:v${BUILD_ID} marviigrey/cryptit:latest"
                }
            }
        }
        stage("build container") {
            steps{
                sh 'docker run -itd --name my-cryptit-app -p 3000:3000 marviigrey/cryptit:v9'
            }
        }
    }
}
