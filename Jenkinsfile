pipeline {
  agent any
  stages {
    stage('Saludo') {
      steps {
        parallel(
          "Saludo": {
            echo 'Hello world DevOps!'
            
          },
          "Obtener cambios SCM": {
            git 'https://github.com/adrianmoya/sampleapp.git'
            
          }
        )
      }
    }
    stage('Pruebas Unitarias') {
      steps {
        bat 'mvn clean test'
        junit 'target/surefire-reports/*.xml'
      }
    }
    stage('Integration Tests') {
      steps {
        bat 'mvn clean verify -DskipUTs'
        junit 'target/failsafe-reports/*.xml'
      }
    }
    stage('Analisis de código') {
      steps {
        bat 'mvn -DskipTests checkstyle:checkstyle pmd:pmd findbugs:findbugs'
        checkstyle(pattern: 'target/checkstyle-result.xml')
        pmd(pattern: 'target/pmd.xml')
        findbugs(pattern: 'target/findbugsXml.xml')
      }
    }
    stage('Publicar artefacto') {
      steps {
        bat 'mvn clean package -DskipTests'
        archiveArtifacts 'target/webapp*.jar'
      }
    }
  }
}