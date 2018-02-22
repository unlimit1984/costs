# Costs

* [Short description](#short-description)
* [How to download](#how-to-download)
* [How to test](#how-to-test)
* [How to run](#how-to-run)

## Short description

This is application for collecting and monitoring daily expenses (costs).
Add payment after each shopping, categorize your purchases.
Finally get simple diagram with customized (daily, monthly, annual) statistics of your costs.       

## How to download
* install git
* git clone https://github.com/unlimit1984/costs.git

## How to test
1. install maven
2. go to project folder by "cd" command in Terminal (Mac) or any Command Line Commander (Windows)
3. mvn clean test

## How to run

1. install jdk8
2. install maven
3. go to project folder
4. mvn tomcat7:run
5. go http://localhost:8080/costs

###History of changes
 - add apache maven plugin
 - add Thymeleaf configuration