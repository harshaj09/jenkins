pipeline {
    agent any
    stages {
        stage ('FirstStage') {
            when {
                equals expected: 5, actual: currentBuild.number
            }
            steps {
                echo "Build the artifact"
            }
        }
    }
}