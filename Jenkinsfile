pipeline {
  agent any
  environment {
    ACCESS_TOKEN = credentials('jfrog_access_token')
  }
  stages {
    stage('Build') {
      steps {
        echo 'Clean project....'
        sh './gradlew clean'
        echo 'Build project....'
        sh './gradlew build'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }
    stage('Publish to JFrog Artifactory') {
      steps {

        echo 'Pushing to JFrog....'
        sh 'jf rt upload --url http://20.24.71.53:8082/artifactory --access-token $ACCESS_TOKEN build/libs/jfrog-spring-boot-0.0.1-SNAPSHOT.jar java-web-app/'
      }
    }
  }
}
