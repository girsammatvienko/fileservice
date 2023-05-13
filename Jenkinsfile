pipeline {
    agent any

    environment {
        JAVA_HOME = credentials('JAVA_HOME')
        MAVEN_HOME = credentials('MAVEN_HOME')
        PATH = "$PATH:/usr/local/bin"
        EMAIL_RECIPIENT = credentials('EMAIL_RECIPIENT')
    }

    stages {
        stage('Initialization') {
            steps {
                sh 'docker-compose down'
            }
        }
        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/mvn clean install -DskipTests"
                sh 'docker-compose build'
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh 'docker-compose -f docker-compose.staging.yml up -d'
            }
        }
        stage('Test on Staging') {
            steps {
                sh "$MAVEN_HOME/mvn test -Denv=staging"
            }
            post {
                always {
                     sh 'docker-compose -f docker-compose.staging.yml down'
                     emailext subject: 'Staging Test Notification',
                              body: 'Staging tests completed successfully.',
                              to: "$EMAIL_RECIPIENT"
                   }
            }
        }
        stage('Deploy to Production') {
            steps {
                sh 'docker-compose -f docker-compose.production.yml up -d'
            }
        }
        stage('Test on Production') {
            steps {
                sh "$MAVEN_HOME/mvn test -Denv=production"
            }
            post {
                always {
                     emailext subject: 'Production Test Notification',
                              body: 'Production tests completed successfully.',
                              to: "$EMAIL_RECIPIENT"
                   }
            }
        }
    }
}
