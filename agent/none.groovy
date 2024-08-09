pipeline {
    agent none 
    stages {
        stage ('first stage') {
            agent {
                label "controller"
            } 
            steps {
                echo "first build"
                sh "hostname -i"
            }
        }
        stage ('second stage') {
            agent {
                label "slave"
            }
            steps {
                sh "hostname -i"
                echo "second build"
            }
        }
    }
}