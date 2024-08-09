// sample pipeline
pipeline {
    agent any
    stages {
        stage ('first build') {
            steps {
                echo "first pipeline"
            }
        }
    }
}