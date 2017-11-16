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
        stage("Deploy to Production"){
            steps{
                sh "ansible-playbook playbook.yml -i inventory/production"
            }
        }
    }
}
