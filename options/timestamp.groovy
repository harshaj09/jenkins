pipeline {
    agent any 
    stages {
        stage ('Build') {
            options {
                timestamps() 
            }
            steps {
                echo "Hello-world!!"
            }   
        }
    }
}

pipeline {
    agent any 
    options {
        timestamps()
    }
    stages {
        stage ('Build') {
            steps {
                echo "Build the artifact"
            }
        }
        stage ('Scan') {
            steps {
                echo "Test the code quality"
            }
        }
    }
}

pipeline {
    agent any 
    options {
        timestamps()
    }
    tools {
        maven 'maven-com'
    }
    stages {
        stage ('Build') {
            steps {
                echo "Build the artifact"
            }
        }
        stage ('Scan') {
            agent {
                label 'slave'
            }
            steps {
                echo "Test the code quality"
                sh "hostname -i"
                sh "mvn --version"
            }
        }
    }
}