pipeline {
  agent any
  stages {
    stage('SCM') {
      steps {
        git(url: 'https://github.com/adrianmoya/sampleapp', branch: 'master')
      }
    }
    stage('Unit tests') {
      steps {
        bat 'mvn test'
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
        checkstyle(pattern: 'target/checkstyle-result.xml')
        findbugs(pattern: 'target/findbugsXml.xml')
        pmd(pattern: 'target/pmd.xml')
      }
    }
    stage('Publish Artifact') {
      steps {
        sh 'mvn package'
        archiveArtifacts 'target/webapp*.jar'
      }
    }
  }
}