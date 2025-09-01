pipeline {
    agent any

    tools {
        maven 'Maven 3.9.11' // Make sure this is configured in Jenkins Global Tools
        jdk 'JDK 21'        // Or your preferred JDK version
    }

    environment {
        GIT_REPO = 'https://github.com/JitendraGawandePrftQA/GeriMedWebAutomation.git'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: "${env.GIT_REPO}", branch: 'master'
            }
        }

        stage('Build') {
            steps {
                echo 'Running Maven Build...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Selenium Tests...'
                bat 'mvn test'
            }
        }

        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
