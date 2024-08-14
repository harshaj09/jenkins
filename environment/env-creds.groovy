pipeline {
    agent any
    stages {
        stage ('FirstStage') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'harsha-github-creds', passwordVariable: 'GITHUB_PASSWD', usernameVariable: 'GITHUB_USR')]) {
                    echo "GitHub username is: ${GITHUB_USR}"
                    echo "GitHub password is: ${GITHUB_PASSWD}"
                }
            }
        }
    }
}