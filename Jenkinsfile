pipeline {
    agent any  
    environment {
        DOCKER_IMAGE_NAME = 'pumas-club' 
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/rafasando50/Pumas-Club.git', branch: 'main'  
            }
        }

        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build -x test'  
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${DOCKER_IMAGE_NAME} .'  
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    sh 'docker run -d -p 8080:8080 ${DOCKER_IMAGE_NAME}'  
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'docker-hub-credentials', url: 'https://index.docker.io/v1/']) {
                        
                        bat 'docker push oliveruwu/pumas-club' 
                    }
                }
            }
        }
    }

    post {
        
        always {
            echo 'Pipeline finalizado.'
        }

        success {
            echo 'Pipeline completado exitosamente.'
        }

        failure {
            echo 'El pipeline falló. Revisa los logs para más detalles.'
        }
    }
}
