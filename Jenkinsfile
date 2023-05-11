pipeline {

  environment {
    dockerimagename = ""
    dockerImage = "natakravchenko/web-app"
  }

  agent any

  stages {
    stage('Checkout Source') {
      steps {
        git branch: 'main' , url: 'https://github.com/Tashie/jenkins-review-demo.git'
      }
    }

    stage("Compilation") {
       steps {
           sh "./mvnw clean install -DskipTests"
       }
    }

    stage("Build image") {
       steps {
           sh "/usr/local/bin/docker build -t ${dockerImage} ."
       }
    }


    stage("Push image to dockerhub") {
       steps {
           sh "/usr/local/bin/docker push ${dockerImage}"
       }
    }

    stage("Deploy to k8s") {
       steps {
           sh "/opt/homebrew/bin/kubectl apply -f deployment.yml"
       }
    }
  }
}