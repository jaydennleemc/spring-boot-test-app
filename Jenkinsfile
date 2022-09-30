pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        echo 'Clean project....'
        sh './gradlew clean'
        echo 'Build project....'
        sh './gradlew build'

        sh 'pwd'
        sh 'ls -la'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }
  }
}
