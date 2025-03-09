pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'LocalSonarQube'   
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/amitb1989/Gradle_project.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'  
            }
        }

        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv('LocalSonarQube') {
                    sh './gradlew sonarqube' 
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
