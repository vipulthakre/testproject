pipeline{
  agent any
  environment{
    def workspaceName = sh(script: "basename ${env.WORKSPACE}", returnStdout:true).trim()
  }
  stages{
    stage('Clone Appplication Source code'){
      steps{
        script{
            git branch: 'main', credentialsId: 'gitcred', url: 'https://github.com/vipulthakre/testproject.git'
        }
      }
    }
    /*stage('Clone Devops code'){
      steps{
        script{
          git branch: 'main', credentialsId: 'gitcred', url: 'https://github.com/vipulthakre/devops_sourceCode.git'
        }
      }
    }*/
    stage('Checkmarx scan'){
      steps{
        script{
          def cx = load 'pipeline.groovy'
          cx.sast()
        }
      }
    }
    stage('Build'){
      steps{
        script{
          def pipeline = load 'pipeline.groovy'
          pipeline.build()
        }
      }
    }
    stage('Upload to Jfrog'){
      steps{
        script{
          def ufg = load 'pipeline.groovy'
          ufg.Jfrog()
        }
      }
    }
  }
  /*post{
    always{
      script{
        cleanWs()
      }
    }
  }*/
}
