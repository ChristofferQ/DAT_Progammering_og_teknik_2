# Guide

#### How to run the project

### Initial Setup:
* Clone the project from Github
* Push to your own branch

### Setup Github Actions for Continuous Integration by doing the following:
* Go into your respository and click on the Actions tab in the menu
* Click on New Workflow
* Then click on set up a workflow yourself and commit the file to branch
* In the sidebar to your left you will see a CI menu item where your able to see that your Github Actions works when pushing your changes to your branch
* Go into settings -> secrets -> new respository secret -> write your tomcat password and tomcat username

# Backend:
* Change persistence.xml usersname and password to your local database
* Create a database schema
* Run SetupTestUser.java file to create the tables so your able to run it in the browser
* Connect to Tomcat server inside the confiugrations menu

# Frontend:
* Open the terminal
* Change directory into the reactjs folder
* Once your inside the folder type <code>npm install</code> to install the packages so the node modules folder appears
* Type <code>npm start</code> to run the project and show it in the browser.

### To view your database inside IntelliJ do the following:
-> On the right side menu click on Database
<br> -> click on the plus
<br> -> Data Source
<br> -> choose MySQL
<br> -> insert your port number, username, password and database name and click apply to see if your connected
<br> -> your database will be showing# Exam-prep
