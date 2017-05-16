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
            git 'git@github.com:adrianmoya/sampleapp.git'
            
          }
        )
      }
    }
    stage('Pruebas Unitarias') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}