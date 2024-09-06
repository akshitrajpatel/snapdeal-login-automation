pipeline {
    agent any
    
    tools {
        maven 'maven'  // Replace with your Maven version
        jdk 'JDK21'          // Replace with your JDK version
    }


    stages {
        stage('Checkout') {
            steps {
                // Fetch the code from your Git repository
                checkout scm
            }
        }
		stage('Verify JAVA_HOME') {
            steps {
                bat 'echo %JAVA_HOME%'
                bat 'java -version'
            }
        }
        
        stage('Install Dependencies') {
            steps {
                // Clean the project and install dependencies
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the TestNG tests
                bat 'mvn test'
            }
        }

        stage('Post-Test Actions') {
            steps {
                // Archive artifacts like JAR files, and publish test results
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'  // JUnit report from Surefire plugin
            }
        }
    }

    post {
        failure {
            echo "Build failed. Email notification would be sent here."
        }
    }
}
