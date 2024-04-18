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
  def command = "${config.EIPO.JFROG.Url}/${config.EIPO.JFROG.Group}"
  sh "curl $command"
  def onemore = "${config.EIPO.JFROG.Url}/get"
  sh "curl $onemore"
}
return this
