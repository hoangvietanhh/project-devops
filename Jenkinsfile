pipeline {
  agent any
  environment {
      GITHUB_TOKEN=credentials('github-token')
    }
  stages {
    stage('build mvn') {
          steps {
            sh 'mvn clean install -Dmaven.test.skip=true'
          }
        }
    stage('login to GHCR') {
           steps {
             sh 'echo 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 | docker login ghcr.io -u vietanhhoang --password-stdin'
          }
        }
    stage('build image') {
      steps {
        sh 'docker build -t hoangvietanhh/project-devops:${version} .'
      }
    }
    stage('tag image') {
          steps {
            sh 'docker tag hoangvietanhh/project-devops ghcr.io/hoangvietanhh/project-devops:${version}'
          }
        }
    stage('push image') {
          steps {
            sh 'docker push ghcr.io/hoangvietanhh/project-devop:${version}'
          }
        }
    stage('label image') {
          steps {
            sh 'LABEL org.opencontainers.image.source https://github.com/hoangvietanhh/project-devops:${version}'
          }
         }
    stage('run image') {
          steps {
            sh 'docker run -dp 8000:8800 ghcr.io/hoangvietanhh/project-devop:${version}'
             }
          }
    stage('log container') {
              steps {
                sh 'docker logs -f ghcr.io/hoangvietanhh/project-devop:${version}'
                 }
              }
  }
}