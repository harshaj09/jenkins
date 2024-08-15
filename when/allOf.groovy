pipeline {
    agent any 
    environment {
        DEPLOY_TO = "release"
    }
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
                expression { 
                    BRANCH_NAME ==~ /(production|stage)/
                }
            }
            steps {
                echo "Deploy the application in Stage"
            }
        }
        stage ('DeployToProd') {
            when {
                allOf { // all conditions should be satisfied
                    branch 'production'
                    environment name: "DEPLOY_TO", value: "release"
                    equals expected: 5, actual: currentBuild.number
                }
            }
            steps {
                echo "Deploy the application in Prod"
            }
        }
    }
}