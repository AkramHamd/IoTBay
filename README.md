# Welcome to Introduction to Software Development!

### Description

The Internet of Things store (IoTBay) is a small company based in Sydney, Australia. IoTBay wants to develop an online IoT devices ordering application to allow their customers to purchase IoT devices (e.g. sensors, actuators, gateways). Based on the initial analysis and meetings with the stakeholders; project team have documented the project brief. The project brief discusses the objectives and current IoTBay device collection management, order management, payment processing, delivery, user registration, login and logout features of the web application.

## Onboarding

##### Join Discord - [https://discord.gg/GuGgVgeE](https://discord.gg/GuGgVgeE)

##### Join Google Drive - [https://drive.google.com/drive/folders/14kSF8y_0XhiM4_hDCA8991ailXe3CbHF?usp=sharing](https://drive.google.com/drive/folders/14kSF8y_0XhiM4_hDCA8991ailXe3CbHF?usp=sharing)

##### Join Trello - [https://trello.com/invite/introtosoftwaredevelopment4/ATTI07592851cf1f5a495a5dc7fd8758aafa6270A044](https://trello.com/invite/introtosoftwaredevelopment4/ATTI07592851cf1f5a495a5dc7fd8758aafa6270A044)

## Installation

Make sure you first install:

- Java JDK (https://www.oracle.com/au/java/technologies/downloads/)
- Maven (https://maven.apache.org/download.cgi) Select the **binary version** not Source

To Run The Project:

Open 2 terminals, side by side in VsCode:

Every time you make a change, run:

`mvn package`

In the other terminal, just run the following & leave it open for as long as you are developing:
`mvn jetty:run`

Then, open a web browser & visit: `http://localhost:8080`

To run unit tests: `mvn test`

## Help Installing Maven

### Mac Users

Macos Users will need to edit their bash_profile file in ~/.bash_profile

Please add the following (Update the path to be wherever you downloaded the maven folder):

```
export M2_HOME="/Users/jack/Downloads/apache-maven-3.6.3"
PATH="${M2_HOME}/bin:${PATH}"
export PATH
```

You can confirm maven was succesfully installed by running `mvn` in your terminal.

### Windows Users

After installing Maven, search for environment variables in windows. This will open a dialogue like so:

![Alt text](images/env.PNG?raw=true 'Environment Variables')

Click the new button under system variables & add one called MAVEN_HOME with a link to the downloaded zip file:

![Alt text](images/systemvar.PNG?raw=true 'Environment Variables')

Find the PATH Variable under user variables & click edit. On the next screen, add a new entry with the value `%MAVEN_HOME%\bin`:

![Alt text](images/uservar.PNG?raw=true 'User Variables')

Close all the menus, reload a terminal window & you can confirm maven was succesfully installed by running `mvn` in your terminal.
