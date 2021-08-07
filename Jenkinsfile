pipeline {
    agent any
    triggers {
        pollSCM '0 * * * *'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build msg'
                sh './gradlew assemble'
            }
        }
        stage('Test'){
            steps {
                echo 'Test msg'
                sh './gradlew test'
            }
        }
        stage('Deliver for development'){
            when {
                expression {env.GIT_BRANCH == 'origin/development'}
            }
            steps {
                echo 'Development msg'
            }
        }
        stage('Deliver for deployment') {
            when {
                expression {env.GIT_BRANCH == 'origin/master'}
            }
            steps {
                echo 'Production msg'
            }
        }
    }
}