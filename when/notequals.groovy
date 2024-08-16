pipeline {
    agent any
    environment {
        DEPLOY_TO = "production"
    }
    stages {
        stage ('FirstBuild') {
            when {
                not {
                    equals expected: "prod", actual: "${DEPLOY_TO}"
                }
            }
            steps {
                echo "Build the artifact"
            }
        }
    }
}

pipeline {
    agent any
    stages {
        stage ('FirstStage') {
            when {
                not { // when the build number is 2 skip the stage
                    equals expected: 2, actual: currentBuild.number
                }
            }
            steps {
                echo "Build the artifact"
            }
        }
    }
}