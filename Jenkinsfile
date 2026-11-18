
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
    }
}
