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
        sh 'mvn clean test'
      }
    }
  }
}