// to change path of the slave use node using customWorkspace
pipeline {
    agent none 
    stages {
        stage ('first build') {
            agent {
                node {
                    label 'slave'
                    customWorkspace '/home/harsha/myspace'
                }
            }
            steps {
                sh "hostname -i"
                echo "first build"
                sh "git clone https://github.com/harshaj09/spring-petclinic.git"
            }
        }
    }
}