# Mutant
Mutant and human DNA validator

## Installation and Run locally

git clone https://github.com/MariaIsabelRinconGuzman/Mutant.git

Use Eclipse 2020-12 (4.18.0)
JDK 1.8
Gradle 7.0.2

For import the project, import as Gradle Project, and for Run the project, search the main class MutantApplication.java and Run as, Java Application.
This project runs in port 5000

The database is configured in file \src\main\resources\application.properties

Generate the .jar is with Gradle Task, run the task Build and the generated .jar are in \build\libs\

## Installation and Run in AWS

The database is MySQL in console.aws.amazon.com/rds/

The environment in AWS where the application will be deployed is in console.aws.amazon.com/elasticbeanstalk/home?region=us-east-2#/environments, Web server environment
Platform: Java, Platform branching : Java 8 running on 64bit Amazon Linux, with default version, Application code : Sample app
And configured user and password for the initial database created.

Next, when the condition is OK, you load and deploy the jar generated with Gradle locally, finally you can test the application with the url with suffix elasticbeanstalk.com.