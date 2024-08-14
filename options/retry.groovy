pipeline {
    agent any
    stages {
        stage ('Build') {
            options {
                retry(3) 
            }
            steps {
                echo "Before setting current build to failure"
                error "test the scenario"
                echo "After setting current build to failure"
            }
        }
    }
}