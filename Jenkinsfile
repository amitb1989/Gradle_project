pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'LocalSonarQube'   
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Merging node { stage('SCM') } logic
            }
        }

        stage('Build') {
            steps {
                bat 'gradlew.bat build'  
            }
        }

        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv('LocalSonarQube') {
                    bat 'gradlew.bat sonar'
                }
            }
        }

        stage('Upload Build Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
