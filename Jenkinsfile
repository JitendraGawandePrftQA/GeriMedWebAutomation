pipeline {
    agent any

    tools {
        maven 'Maven 3.9.11' // Ensure this is configured in Jenkins Global Tools
        jdk 'JDK 21'         // Or your preferred JDK version
    }

    environment {
        GIT_REPO = 'https://github.com/JitendraGawandePrftQA/GeriMedWebAutomation.git'
        MAVEN_OPTS = '-Dfile.encoding=UTF-8'
    }

    options {
        timestamps() // Adds timestamps to console output
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
                bat 'mvn clean package -Dfile.encoding=UTF-8'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Selenium Tests...'
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    bat 'mvn test -Dfile.encoding=UTF-8'
                }
            }
        }

        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        stage('Save Console Output') {
            steps {
                script {
                    try {
                        def logFile = "console-output.txt"
                        def logContent = currentBuild.rawBuild.getLog(10000).join("\n")
                        writeFile file: logFile, text: logContent
                        archiveArtifacts artifacts: logFile, fingerprint: true
                    } catch (e) {
                        echo "Failed to save console output: ${e.message}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }
        success {
