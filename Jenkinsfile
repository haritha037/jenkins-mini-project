pipeline {
    agent any

    tools {
        maven 'M3'
    }
    
    environment {
        IMAGE_NAME = "haritha037/backend"
        IMAGE_VERSION = "${BUILD_NUMBER}"     // Automatic versioning
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/haritha037/jenkins-mini-project.git'
            }
        }

        stage('Run Unit Tests') {
            steps {
                dir('backend') {
                    sh 'mvn clean test'
                }
            }
        }
        
        stage('Build Artifact') {
            steps {
                dir('backend') {
                    sh 'mvn package -DskipTests'
                }
            }
        }
        
        stage('Build docker image') {
            steps {
                script {
                    dir('backend') {
                        sh """
                            echo "Building image: ${IMAGE_NAME}:${IMAGE_VERSION}"
                            docker build -t ${IMAGE_NAME}:${IMAGE_VERSION} .
                            docker tag ${IMAGE_NAME}:${IMAGE_VERSION} ${IMAGE_NAME}:latest
                        """
                    }
                }
            }
        }
        
        stage('Docker Push') {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: 'dockerhub-credentials',
                        usernameVariable: 'DOCKERHUB_USER',
                        passwordVariable: 'DOCKERHUB_PASS'
                    )]) {

                        sh """
                            echo "$DOCKERHUB_PASS" | docker login -u "$DOCKERHUB_USER" --password-stdin

                            echo "Pushing version: ${IMAGE_VERSION}"
                            docker push ${IMAGE_NAME}:${IMAGE_VERSION}

                            echo "Pushing latest..."
                            docker push ${IMAGE_NAME}:latest

                            docker logout
                        """
                    }
                }
            }
        }
    }
}

