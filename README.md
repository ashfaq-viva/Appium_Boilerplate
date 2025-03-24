# MOBILE-AUTOMATION-APPIUM

# This boiler-plate includes following key features:

- ✅ Platform designed dynamically for both Android and iOS, with dynamic locator handling based on the platform
- ✅ Locate locators using pointer and handled dynamically for any device ratio-
- ✅ Framework using Page Object Model (POM)
- ✅ Testing XML setup to run individual test cases or all tests from a single file
- ✅ Programmatic Appium server startup
- ✅ Common utility methods in BasePage for reusability
- ✅ Assertions with SoftAssert support
- ✅ Allure Reporting with a runner file to generate and display reports
- ✅ Generation allure report with bat file
- ✅ Automatic failure screenshots & attachments in Allure reports
- ✅ Video recording of test runs & attachments in Allure reports
- ✅ TestNG test orders for "Smoke," "Sanity," and "Regression" suites
- ✅ Maven Surefire Plugin to support CI/CD execution
- ✅ CI/CD pipeline setup using GitHub Actions
- ✅ Dependency caching for optimized CI/CD performance
- ✅ Email reporting in CI/CD
- ✅ Failure screenshots & screen recordings attached in CI/CD reports

This boilerplate makes mobile automation reusable, efficient, and CI/CD-ready. Feel free to check it out, use it in your projects 🚀


### Prerequisites and set-up:
To run the project, you’ll need to ensure following prerequisites as shown below:
Android Setup & ios setup both can be set by following the doc--

https://docs.google.com/document/d/e/2PACX-1vRnTmwDeynRlYUu9ib-jtkH7Ukas7TWyd0ww-aS6itEKjhXWCaGeI72fJ_0MIwrHG4oCK140Iv7iwBy/pub#h.f1eh23lg92jk

---

### How to run the project and once the above link is understood, here is a short summary to go check

Use Intellij or Aqua 

Step-1: To run the project, execute below command as shown below

    install node: install Node.js, visit the official Node.js download section.

Once the installation is complete, restart the terminal and run the command -> node –version again. It will return the Node version.

This indicates the successful installation of Node.js. The Node.js installation also covers the installation of npm (node package manager).

Mac users can use the node -v and npm -v commands to verify the installation and version details.

To install Appium, run the following command.

    npm install -g appium

The command above will download and install Appium. Once done, verify the Appium installation on macOS or Windows by running the command below:

    appium --version

This will return the latest Appium version installed in your system.


    1. you can run individual tests or multiple tests at a time from testng.xml file.
    2. you can run using groups eg mvn test -Dgroups=sanitySuite
    3.you can run each test from test page

### How It Works?
Test script sends a command (e.g., "Tap this button").

Command is sent to the Appium server at the remoteURL via an HTTP request.

Appium server processes the request and interacts with the device.

Response is sent back to the test script.

Without the remoteURL, the test framework wouldn't know where the Appium server is running and could not initiate or control the test session.

---

### Example of one module is made
    1. Login


---
### Report Analysis
Allure reporting configuration

Steps: 1
Download Latest one

    https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/

steps: 2
Extract and copy Bin location and add to system env path

steps: 3
Select the latest one and past it to your pom.xml file

    https://mvnrepository.com/artifact/io.qameta.allure/allure-testng

steps: 4
Run your suite from .XML file

steps: 5
Open CLI by clicking your project parent folder and selecting show in the local terminal

steps:6
Run these two commands

Generating report

    allure generate ./allure-results --clean

Display report using server

    allure open ./allure-report/

You can run this whole process from run-allure-report.bat file


---
