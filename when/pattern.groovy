pipeline {
    agent any
    stages {
        stage ('DeployToDev') {
            steps {
                echo "Deploy the application in Dev"
            }
        }
        stage ('DeployToTest') {
            steps {
                echo "Deploy the application in Test"
            }
        }
        stage ('DeployToStage') {
            when {
                branch "release/*"
            }
            steps {
                echo "Deploy the application in stage"
            }
        }
        stage ('DeployToProd') {
            when {
                tag pattern: "v\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}", comparator: 'REGEXP'
            }
            steps {
                echo "Deploy the application in Prod"
            }
        }
    }
}