pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                echo "testing mail scenario"
            }
        }
    }
    post {
        success {
            mail bcc: '', body: 'Build is success', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Status', to: 'padmajaganji111@gmail.com'
        }
    }
}

pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                retry(3) {
                    echo "testing mail scenario"
                    error "replicate failure scenario"
                }
            }
        }
    }
    post {
        success {
            mail bcc: '', body: 'Build is success', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Status', to: 'padmajaganji111@gmail.com'
        }
        failure {
            mail bcc: '', body: 'Build is failed', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Status', to: 'padmajaganji111@gmail.com'
        }
    }
}