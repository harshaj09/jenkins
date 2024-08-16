pipeline {
    agent {
        label "slave"
    }
    stages {
        stage ('first stage') {
            steps {
                sh "hostname -i"
                echo "first build"
            }
        }
        stage ('second stage') {
            agent {
                label 'controller'
            }
            steps {
                sh "hostname -i"
                echo "second build"
            }
        }
    }
}