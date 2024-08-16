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
                sleep 10
                echo "slept for 10seconds"
                script {
                    def course='k8s'
                    if (course=='k8s!!')
                    println("thanks for visiting ${course} webpage")
                    else 
                    println("do learn ${course}")
                    sleep 10
                    echo "slept for 10seconds"
                }
            }
        }
    }
}