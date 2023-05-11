pipeline {

  environment {
    dockerimagename = ""
    dockerImage = ""
  }

  agent any

  stages {
    stage('Checkout Source') {
      steps {
        git branch: 'main' , url: 'https://github.com/Tashie/jenkins-review.git'
      }
    }

    stage("Compilation") {
       steps {
           sh "./mvnw clean install -DskipTests"
       }
    }
  }
}