pipeline {
    agent any 
    environment {
        NAME = "Harsha"
        COURSE = "Devops"
    }
    stages {
        stage ('FirstStage') {
            environment {
                CLOUD = "GCP"
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
            }
        }
    }
}

pipeline {
    agent any 
    environment {
        NAME = "Harsha"
        COURSE = "Devops"
    }
    stages {
        stage ('FirstStage') {
            environment {
                CLOUD = "GCP"
                COURSE = "Docker & K8s"
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
            }
        }
    }
}

pipeline {
    agent any 
    environment {
        NAME = "Harsha"
        COURSE = "Devops"
    }
    stages {
        stage ('FirstStage') {
            environment {
                CLOUD = "GCP"
                COURSE = 'Docker & K8S'
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
            }
        }
        stage ('SecondStage') {
            environment {
                NAME = "Manideep"
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
            }
        }
    }
}

pipeline {
    agent none 
    environment {
        NAME = "Harsha"
        COURSE = "Devops"
    }
    stages {
        stage ('FirstStage') {
            agent {
                label 'controller'
            }
            environment {
                CLOUD = "GCP"
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
                sh "printenv"
            }
        }
        stage ('SecondStage') {
            agent {
                label 'slave'
            }
            environment {
                NAME = "Manideep"
                CLOUD = "Azure"
            }
            steps {
                echo "Hello ${NAME}"
                echo "Thanks for enrolling ${COURSE}"
                echo "Are you certified in ${CLOUD} ?"
                sh "printenv"
            }
        }
    }
}