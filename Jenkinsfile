pipeline {
    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9'
    }

    environment {
        APP_NAME = 'Ejercicio5Cliente'
    }

    stages {
        stage('1. Checkout Frontend') {
            steps {
                checkout scm
            }
        }

        stage('2. Compilación (Java 21)') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('3. Pruebas Unitarias (Surefire)') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('4. Cobertura de Código (JaCoCo)') {
            steps {
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    jacoco execPattern: 'target/jacoco.exec',
                           classPattern: 'target/classes',
                           sourcePattern: 'src/main/java',
                           inclusionPattern: '**/controller/VistaController.class'
                }
            }
        }

        stage('5. Análisis Estático (SonarQube)') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('6. Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('7. Empaquetado de Artefacto (JAR)') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "Pipeline Frontend [Ejercicio5Cliente] finalizado con éxito y Quality Gate aprobado."
        }
        failure {
            echo "Fallo en el Pipeline Frontend. Verifique los reportes de pruebas o calidad."
        }
    }
}
