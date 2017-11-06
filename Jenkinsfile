def projectName = "dinero-java";
def majorVersion = 3;
def minorVersion = 0;
def buildVersion = env.BUILD_NUMBER;
def version = "$majorVersion.$minorVersion.$buildVersion";

node {

    def v;

    stage('Checkout') {
        checkout scm

    }

    stage('Build') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github-ci', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

            withMaven(
                maven: 'Maven 3',
                mavenSettingsConfig: 'maven_settings',
                jdk: 'JDK 8') {

                // Force version
                // sh "mvn versions:set -DnewVersion=${version}"

                // Run the maven build
                sh "mvn clean install"
            }
        }
    }

    if(env.BRANCH_NAME == "master") {


        stage('Tag it') {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github-ci', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
                withMaven(
                    maven: 'Maven 3',
                    mavenSettingsConfig: 'maven_settings',
                    jdk: 'JDK 8') {

                    echo "Resolving version"
                    def pom = readMavenPom file: 'pom.xml'
                    def tmp = pom.version

                    echo "Version found in pom: ${tmp}"
                    tmp = tmp.replaceAll("-SNAPSHOT", "")
                    def result = tmp.tokenize('.');
                    echo "Resolves to ${result}"

                    def major = result[0];
                    def minor = result[1];
                    def patch  = result[2];
                    v = "${major}.${minor}.${patch}"
                    if (v) {
                        echo "Building version ${v}"
                    }
                    sh "mvn -B versions:set -DgenerateBackupPoms=false -DnewVersion=${v}"
                    sh 'git add .'
                    sh "git commit -m 'Raise version'"
                    sh "git tag v${v}"

                }
            }
        }

        stage('Release it') {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github-ci', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

                withMaven(
                    maven: 'Maven 3',
                    mavenSettingsConfig: 'maven_settings',
                    jdk: 'JDK 8') {

                    sh "mvn -B -DskipTests clean deploy"

                    //sh "git push origin " + env.BRANCH_NAME
                    sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/michaelkrog/dinero-java v${v}"

                }
            }
        }


    }


}