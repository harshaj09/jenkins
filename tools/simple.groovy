pipeline {
    agent any
    tools {
        maven 'maven-com'
    }
    stages {
        stage ('Build') {
            steps {
                echo "Build the artifact"
                sh "mvn --version"
            }
        }
        stage ('Scan') {
            steps {
                echo "Scan the artifact"
            }
        }
    }
}