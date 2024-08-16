pipeline {
    agent {
        label 'slave'
    }
    stages {
        stage ('BuildStage') {
            steps {
                echo "build the artifact"
            }
        }
        stage ('SonarStage') {
            steps {
                echo "perform sonar scans"
                script {
                    def course="k8s"
                    if (course=="k8s")
                    println("thanks for visiting k8s page")
                    else 
                    println("do learn k8s")
                }
            }
        }
    }
}