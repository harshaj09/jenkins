pipeline {
     agent any 
     stages {
        stage ('Builds') {
            steps {
                echo "Build the application"
            }
        }
        stage ('ParallelScans') {
            parallel {
                stage ('SonarScan') {
                    steps {
                        echo "Execute Sonar scans"
                    }
                }
                stage ('FortifyScan') {
                    steps {
                        echo "Execute Fortify scans"
                    }
                }
                stage ('PrismaScan') {
                    steps {
                        echo "Execute Prisma scans"
                    }
                }
                stage ('TrivyScan') {
                    steps {
                        echo "Execute Trivy scans"
                    }
                }
            }
        }
        stage ('DockerBuild') {
            steps {
                echo "Build the Docker image"
            }
        }
        stage ('DockerPush') {
            steps {
                echo "Push the image to registry"
            }
        }
     }
}
