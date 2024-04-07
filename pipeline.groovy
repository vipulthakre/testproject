def sast(){
  echo "Checkmarx stage"
}
def build(){
  sh "chmod +x -R ${env.WORKSPACE}"
  sh "/var/lib/jenkins/workspace/${workspaceName}/build_app.sh ${workspaceName}"
}
def Jfrog(){
  echo "Jfrog Stage"
}
return this
