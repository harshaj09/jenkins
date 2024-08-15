pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Build the artifact"
            }
        }
        stage ('Test') {
            steps {
                echo "Test the artifact"
            }
        }
        stage ('DeployToDev') {
            steps {
                echo "Deploy the app in dev"
            }
        }
        stage ('deployToTest') {
            steps {
                echo "deploy the app in Test"
            }
        }
        stage ('deployToPrd') {
            steps {
                timeout (time: 150, unit: 'SECONDS') {
                    input message: "Would you like to promote to Prod?", ok: 'yes', submitter: 'padmaja'
                }
                echo "deply the application in Prod"
            }
        }
    }
}
