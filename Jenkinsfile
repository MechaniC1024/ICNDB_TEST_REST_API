pipeline {
  agent any
  options {buildDiscarder (logRotator (numToKeepStr: '5'))}
  stages{
    stage("TEST"){
      steps{
        git url: "https://github.com/MechaniC1024/ICNDB_TEST_REST_API.git"
        dir("ICNDB"){
          bat ''' mvn clean test site '''
        }
      }
    }
    stage("REPORT"){
        steps{
            allure ([includeProperties: true, 
                  reportBuildPolicy: 'ALWAYS',
                  report: 'target/allure-report', 
                  results: [[path: 'Icndb/target/allure-results']]
            ])
        }
    }
  }
  post{
      always{
		emailext attachmentsPattern: '**/123.zip', 
		         body: 'Find attachments', 
		         subject: 'Attached report', 
		         to: 'bog2641@yandex.ru'
	}
  }
}  
