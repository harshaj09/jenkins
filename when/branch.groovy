pipeline {
    agent any 
    stages {
        stage ('DeployToDev') {
            steps {
                echo "Deploy the application in Dev environment"
            }
        }
        stage ('DeployToProd') {
            when {
                expression {
                    BRANCH_NAME ==~ /(production)/
                }
            }
            steps {
                echo "Deploy the application in Production environment"
            }
        }
    }
}