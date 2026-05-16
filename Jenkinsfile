pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            // Mount the local Maven repository to a path accessible by the jenkins user
            args '-v $HOME/.m2:/var/maven/.m2'
        }
    }

    environment {
        // Tell Maven to use the mounted repository instead of the default ~/.m2
        MAVEN_OPTS = '-Dmaven.repo.local=/var/maven/.m2'
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
