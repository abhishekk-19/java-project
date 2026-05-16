pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            // Mount the local Maven repository to speed up subsequent builds
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout source code from the configured SCM (Git, etc.)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run Maven build, skipping tests for this stage
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn -B test'
            }
            post {
                always {
                    // Archive the test results
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deliver') {
            steps {
                // Archive the built JAR file
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
