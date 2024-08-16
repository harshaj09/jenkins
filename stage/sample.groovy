pipeline {
    agent {
        label "slave"
    }
    stages {
        stage ('BuildStage') {
            steps {
                echo "build the artifact"
                sh "hostname -i"
            }
        }
        stage ('ScanStage') {
            steps {
                echo "perform sonar scans"
            }
        }
    }
}