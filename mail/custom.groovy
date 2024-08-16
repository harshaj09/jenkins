pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Build the artifact"
                // error "failed scenario"
            }
        }
    }
    post {
        always {
            script {
                def subject = "Jenkins Job status: ${currentBuild.currentResult}"
                def body = "Build Number is: ${currentBuild.number}\n" + "Job status is: ${currentBuild.currentResult}\n" + "Job URL: ${env.BUILD_URL}"
                mail ( to: "padmajaganji111@gmail.com", subject: subject, body: body )
            }
        }
    }
}