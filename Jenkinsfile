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
        stage('Build Docker image'){
        	steps {
        		sh './gradlew docker'
        	}
        }
        stage('Push Docker image'){
        	environment {
        		DOCKER_HUB_LOGIN = credentials('docker-hub')
        	}
        	steps {
        		sh 'docker login --username=$DOCKER_HUB_LOGIN_USER --password=$DOCKER_HUB_LOGIN_PSW'
        		sh './gradlew dockerPush'
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