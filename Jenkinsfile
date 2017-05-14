pipeline {
  agent {
    docker {
      image 'maven:3.5-alpine'
    }
    
  }
  stages {
    stage('Welcome') {
      steps {
        echo 'Hello Jenkins again!'
      }
    }
    stage('Unit tests') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Report') {
      steps {
        junit 'target/surefire-reports/*.xml'
      }
    }
  }
}