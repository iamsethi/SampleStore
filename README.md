# Sample Store
UI Automation Cucumber BDD Framework for execution on Chrome and Firefox 

## Tools
* LANGUAGE : JAVA 
* AUTOMATION : SELENIUM
* REPORTER : EXTENT REPORTER

## Architecture
* ./src/test/java : Contains all step definitions and runner class
* ./src/test/resources : 
  * Feature Files : Writing the test cases in Gherkin language
* ./src/main/java : 
  * Driver : Contains all the driver factory classes
  * Pages : Contains project related Page Objects

## Reports
target/extentreports/extent.html

## Commands To Execute
* Run shell file under bin folder
* CLI execution - mvn clean test -Dbrowser=chrome
