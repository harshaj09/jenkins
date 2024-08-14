pipeline {
    agent any
    options {
        timeout(time: 10, unit: 'SECONDS')
    }
    stages {
        stage ('Build') {
            steps {
                echo "Hello World!!"
                sh "sleep 15"
            }
        }
    }
}