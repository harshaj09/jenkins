pipeline {
    agent any 
    stages {
        stage ('DeployToDev') {
            steps {
                echo "Deploy the application in Dev"
            }
        }
        stage ('DeployToProd') {
            when {
                changeRequest()
            }
            steps {
                echo "Deploy the application in Production"
            }
        }
    }
}