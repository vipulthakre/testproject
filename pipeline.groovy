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
  def config = readJSON file: 'config.json'
  def command = "${config.EIPO.JFROG.Url}/${config.EIPO.JFROG.Url}"
  sh "curl $command"
}
return this
