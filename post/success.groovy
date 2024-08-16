pipeline {
    agent any
    stages {
        stage ('FirstBuild') {
            steps {
                echo "Build the artifact"
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