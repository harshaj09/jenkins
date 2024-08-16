pipeline {
    agent any
    stages {
        stage ('Build') {
            agent {
                label 'slave'
            }
            tools {
                maven 'maven-com'
            }
            steps {
                sh "mvn --version"
                error "replicating the error scenario"
            }
        }
    }
    post {
        success {
            echo "post ===> success got triggered"
        }
        failure {
            echo "post ===> failure got triggered"
        }
        always {
            echo "post ===> always got triggered"
        }
    }
}