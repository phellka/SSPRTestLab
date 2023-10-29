properties([disableConcurrentBuilds()])
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git([url: 'https://github.com/phellka/SSPRTestLab.git', branch: 'master'])
                bat './gradlew build'
            }
        }
        stage('Test') {
            steps {
                bat './gradlew test'
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage("Create Docker Image") {
            steps {
                bat 'docker image build -t phellka1/app .'
            }
        }
        stage("Push Image To Docker Hub") {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwd", variable: 'dockerhubpwd")]) {
                    bat 'echo ${dockerhubpwd}'
                    bat "docker login --username phellka1 --password ${dockerhubpwd}"
                    bat 'docker push phellka1/app'
                }
            }
    }
}