pipeline {
    agent any 
    environment {
        GIT_CREDS = credentials('harsha-github-creds')
    }
    parameters {
        string(name: "NAME", defaultValue: "Harsha", description: "Name of the person")
        choice(name: "ENV", choices: ['dev', 'test', 'prod'], description: "In which environment you want to deploy the application")
        booleanParam(name:'TOGGLE', defaultValue: true, description: "Do you want scan the source code?")
        text(name: 'PARA', defaultValue: '', description: "Enter high level fixes for the release")
        password(name: 'PASSWD', defaultValue: 'SECRET', description: "Enter your password")
    }
    stages {
        stage ('Parameters Example') {
            steps {
                echo "Welcome ${params.NAME}"
                echo "Deploy the application in ${params.ENV}"
                echo "Are scans happening: ${params.TOGGLE}"
                echo "Fixes done in the release: ${params.PARA}"
                echo "GitHub credentials are: ${GIT_CREDS}"
                echo "GitHub username is : ${GIT_CREDS_USR}"
                echo "Entered password is: ${GIT_CREDS_PSW}"
            }
        }
    }
}
