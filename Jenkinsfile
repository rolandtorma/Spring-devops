pipeline{
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url: "https://github.com/rolandtorma/Spring-devops.git"
            }
        }
        stage("Packaging"){
            steps{
                sh "./gradlew build"
            }
        }
        stage("Docker build"){
            steps{
                sh "docker build -t troland94/devops-pelda ."
            }
        }
        stage("Docker login"){
            steps{
                sh "docker login --username=troland94 --password=$docker_password"
            }
        }
        stage("Docker push"){
            steps{
                sh "docker push troland94/devops-pelda"
            }
        }
        stage("Docker to Staging"){
            steps{
                sh "docker run -d --rm -p 8765:8080 --name calculator troland94/devops-pelda"
            }
        }
        stage("Acceptance test"){
            steps{
                sh "sleep 60"
                sh "./acceptance_test.sh"
            }
        }
    }
    post {
        always{
            sh "docker stop calculator"
        }
    }
}
