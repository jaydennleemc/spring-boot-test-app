pipeline {
  agent any
  environment {
    ACCESS_TOKEN = credentials('jfrog_access_token')
    JAR_FILE = 'build/libs/jfrog-spring-boot-0.0.1-SNAPSHOT.jar'
    REPOSITORY_NAME = 'java-web-app/'
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
      when {
        expression { return env.BRANCH_NAME == 'develop' }
      }
      steps {
        echo 'Testing...'
      }
    }
    stage('Publish to JFrog artifactory') {
      steps {
        echo 'Publish jar to jfrog artifactory...'
        sh 'jf rt upload --url http://20.24.71.53:8082/artifactory --access-token $ACCESS_TOKEN $JAR_FILE $REPOSITORY_NAME'
      }
    }
    post {
      // always execute if all stages finished
      always {
        echo 'Cleaning up...'
        sh './gradlew clean'
      }
      // execute if any stage success
      success {
        echo 'Build success'
      }
      // execute if any stage failed
      failure {
        echo 'Build failed'
      }
    }
  }
}
