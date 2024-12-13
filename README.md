# Selenium Automation Framework with Java & Cucumber

## 🚀 Project Overview


This project is an Automation Testing Framework using Selenium, Java, Cucumber, and Maven. The framework is designed to test core functionalities of a sample web application, including:
1. Login Tests (successful login & failure scenarios)
2. Dynamic Table Validation (data matching and column sum calculations)
3. Cascading Dropdown Tests (dynamic dropdown updates based on user input)

## **🛠️ Framework Features**

- Page Object Model (POM): Clear separation of UI logic and test code for reusability.
- Cucumber Integration: Behavior-Driven Development with .feature files.
- Cross-browser Testing: Support for Chrome and Firefox.
- Parameterized Tests: Run tests with multiple data sets easily.
- Detailed Reporting: Generated using ExtentReports.

## **🔧 Tech Stack**

- Java 8
- Maven
- Selenium 4.x
- Cucumber 7.11.2
- JUnit 5 (Jupiter)
- ExtentReports for reporting
- WebDriverManager
- Rest-Assured for API Testing

## 📂 Features

- Login Functionality:
Test both valid & invalid login scenarios.

- Dynamic Table Validation:
Check data integrity & column calculations.

- Cascading Dropdown Tests:
Simulate dynamic interactions between dependent dropdowns.

- Cross-Browser Support:
Tests are parameterized to execute across multiple browsers.

- Reusable Utilities:
Utilities like logging, configuration management, and driver setup.

- Test Reports:
Detailed test execution results using ExtentReports.

# ⚙️ Setup Instructions
### 1. Clone Repository
        git clone https://github.com/haisanjayssk/selenium_project.git
cd selenium_project

### 2. Build the Project
Ensure dependencies are downloaded:

        mvn clean install

### 3. Run Tests
You can run tests on specific browsers by passing the browser parameter. Supported browsers include Chrome and Firefox.

- Example: Run on Chrome (default)

        mvn test
  
- Example: Run on Firefox

        mvn test -Dbrowser=firefox
  

### 4. View Test Reports
After execution, reports can be found here:

        target/cucumber-reports.html
        target/extent-report.html
## 📌 Note
- The table validation feature loads data from **w3schools Table**.
- Network Speed Impact: The speed of loading depends on your current network speed.
- Ensure you have an active internet connection for smooth execution.

## 🤖 Environment Configuration

- Tests are configured for Java 8. Adjust the maven.compiler.source and maven.compiler.target if using a different version.
Ensure WebDriverManager is compatible with your environment to auto-manage driver versions.

## 🏆 Reporting
- Reports are generated using **ExtentReports**, and will give insights into test case status, execution time, and logs.

## 📜 Assumptions/Limitations
- Tests assume the index.html runs locally (localhost port **5500**).

## Test Report
- You can view the [EXTEND TEST REPORT HERE](https://haisanjayssk.github.io/selenium_project/extent-reports.html)

## CI/CD Pipeline

- This project uses **GitHub Actions** for continuous integration and test execution instead of Jenkins.
- You can view the workflow configuration in the [`.github/workflows`](https://github.com/haisanjayssk/selenium_project/tree/main/.github/workflows) directory.

