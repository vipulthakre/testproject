/*def sast(){
  echo "Checkmarx stage"
}
def build(){
  sh "chmod +x -R ${env.WORKSPACE}"
  sh "/var/lib/jenkins/workspace/${workspaceName}/build_app.sh ${workspaceName}"
}
def UTJF(){
  echo "Jfrog Stage"
}*/
def test(){
  
  sh 'curl http://httpbin.org/get'
}
return this
