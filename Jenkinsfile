pipeline {
  agent {
    docker {
      image 'maven:3.5-alpine'
    }
    
  }
  stages {
    stage('SCM') {
      steps {
        git(url: 'https://github.com/adrianmoya/sampleapp', branch: 'master')
      }
    }
    stage('Unit tests') {
      steps {
        sh 'mvn test'
        junit 'target/surefire-reports/*.xml'
      }
    }
    stage('Integration Tests') {
      steps {
        sh 'mvn clean verify -DskipUTs'
        junit 'target/failsafe-reports/*.xml'
      }
    }
    stage('Quality') {
      steps {
        sh 'mvn checkstyle:checkstyle findbugs:findbugs pmd:pmd'
        junit 'target/checkstyle-result.xml,target/findbugsXml.xml, target/pmd.xml'
      }
    }
  }
}