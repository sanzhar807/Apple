pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                bat 'gradlew.bat clean test || exit 0'
            }
        }

        stage('Allure Report') {
            steps {
                allure([
                    results: [[path: 'build/allure-results']]
                ])
            }
        }

        stage('Telegram Notification') {
            steps {
                script {
                    def jarPath = "${WORKSPACE}/notifications/allure-notifications-4.6.1.jar"
                    def configPath = "${WORKSPACE}/notifications/config.json"
                    bat """
                        java -DconfigFile=${configPath} -jar ${jarPath}
                    """
                }
            }
        }
    }

    post {
        always {
            allure([
                results: [[path: 'build/allure-results']]
            ])
        }
    }
}