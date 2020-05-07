pipeline {
    agent any
    environment {
        PROD_GIT = "git+ssh://git@push-par-clevercloud-customers.services.clever-cloud.com/app_0f86d9b9-269b-40f5-a502-8f9d9bf6f9e2.git"
        GIT_CREDENTIAL_ID = '498f56ad-08cc-4ce4-a8dc-d21027509ca5'
    }
    stages {
        stage('build') {
            steps {
                sh './mvnw clean package'
            }
        }
         stage('deploy') {
             when {
                branch 'master'
            }
            steps {
               sshagent(["${GIT_CREDENTIAL_ID}"]) {
                  sh "git checkout ${GIT_BRANCH}"
                  sh "git pull"
                  sh "git push --force ${PROD_GIT} ${GIT_BRANCH}:master"
                  discordSend link: "${env.BUILD_URL}", result: "${currentBuild.currentResult}", title: "Déploiement Back ! ${env.JOB_NAME} commit ${env.GIT_COMMIT}", webhookURL: "${DISCORD_D2020_D02}"
               }
            }
        }
    }
    post {
       failure {
          discordSend link: "${env.BUILD_URL}",  result: "${currentBuild.currentResult}", title: "oops ! ${env.JOB_NAME} commit ${env.GIT_COMMIT}", webhookURL: "${DISCORD_D2020_D02}"
       }
    }
}
