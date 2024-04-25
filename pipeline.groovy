/*def sast(){
  echo "Checkmarx stage"
}
def build(){
  sh "chmod +x -R ${env.WORKSPACE}"
  sh "/var/lib/jenkins/workspace/${workspaceName}/build_app.sh ${workspaceName}"
}
def UTJF(){
  echo "Jfrog Stage"
}
def test(){
  def config = readJSON file: 'config.json'
  def command = "${config.EIPO.JFROG.Url}/${config.EIPO.JFROG.Group}"
  sh "curl $command"
  def onemore = "${config.EIPO.JFROG.Url}/get"
  sh "curl $onemore"
}*/

def postActions() {
  def buildNumber = env.BUILD_NUMBER
  def jobName = env.JOB_NAME
  def buildResult = currentBuild.result ?: 'UNKNOWN'
  def consoleOutputUrl = env.BUILD_URL
  
  sh "chmod +x mail.sh"
  sh "ls -l mail.sh" // Check if script exists and has execute permissions
  sh "./mail.sh '${buildResult}' '${consoleOutputUrl}' '${buildNumber}'"
}

return this
