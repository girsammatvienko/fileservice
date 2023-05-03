pipeline {
    agent any

    environment {
        JAVA_HOME = '/Users/girsammatvienko/Library/Java/JavaVirtualMachines/corretto-1.8.0_372/Contents/Home'
        PATH = "$PATH:/usr/local/bin"
    }

    stages {
//         stage('Init') {
//             steps {
//                 sh 'docker-compose down'
//             }
//         }
//         stage('Build') {
//             steps {
//                 sh '/opt/homebrew/bin/mvn clean install -DskipTests'
//                 sh 'docker-compose build'
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 sh 'docker-compose up -d'
//             }
//         }
        stage('Test') {
            steps {
                sh '/opt/homebrew/bin/mvn test'
            }
            post {
                always {
                     emailext subject: 'Build Notification',
                              body: 'Build completed successfully.',
                              to: 'gasdssd1@gmail.com'
                   }
            }
        }
    }

}