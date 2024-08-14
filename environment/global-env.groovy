pipeline {
    agent {
        label 'slave'
    }
    environment {
        NAME = 'Harsha'
        COURSE = 'Docker & K8S'
        CLOUD = 'GCP'
    }
    stages {
        stage ('FirstStage') {
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
            }
        }
    }
}