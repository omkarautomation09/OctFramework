# OpenCart Selenium Automation Framework

## 1. Project Overview

**OpenCart Selenium Automation Framework** is a Java-based web automation testing framework developed using Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM) design pattern.

The framework automates important e-commerce application workflows, including user registration, login, product search, product-related operations, shopping cart, wishlist, and checkout.

The primary objective of this project is to build a maintainable, reusable, and scalable automation framework that can be used to validate critical application functionality and reduce repetitive manual testing efforts.

**Application Under Test:** [TutorialsNinja OpenCart Demo](https://tutorialsninja.com/demo/)

**GitHub Repository:** https://github.com/omkarautomation09/OctFramework

---

## 2. Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language for automation scripts |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and test management |
| Maven | Dependency management and build automation |
| Page Object Model (POM) | Maintainable page-level architecture |
| Apache POI | Excel-based test data handling |
| Git | Version control |
| GitHub | Source code repository |
| Jenkins | CI automation and build execution |
| ExtentReports | Test reporting integration |

---

## 3. Framework Architecture

The framework follows a layered architecture to separate test logic, page interactions, reusable utilities, and configuration.

### Main framework components

**1. Base Layer**
- Initializes the WebDriver.
- Handles browser setup and teardown.
- Provides common setup functionality for test classes.

**2. Page Layer**
- Contains page classes representing application pages.
- Stores web element locators.
- Implements reusable page actions and methods.
- Keeps page interaction logic separate from test scripts.

**3. Test Layer**
- Contains TestNG test classes.
- Executes application test scenarios.
- Validates expected and actual results.
- Uses reusable methods from the page layer.

**4. Utility Layer**
- Provides reusable framework functionality.
- Supports configuration reading.
- Handles Excel-based test data.
- Supports screenshot-related operations.

**5. Configuration Layer**
- Stores application URL and browser configuration.
- Maintains reusable execution settings.
- Helps avoid hardcoding configuration values throughout the framework.

---

## 4. Key Framework Features

### Page Object Model (POM)
Implemented POM to separate page locators and page actions from test cases. This improves code reusability and makes maintenance easier when application elements change.

### TestNG Integration
Used TestNG for:
- Test execution.
- Test annotations.
- Test organization.
- Data-driven test execution.
- Test suite management.

### Data-Driven Testing
Implemented TestNG DataProvider to execute test scenarios with multiple sets of test data.

### Excel-Based Test Data
Used Apache POI to read test data from Excel files, allowing test data to be maintained separately from automation scripts.

### Configuration Management
Used a properties file to manage application URL, browser settings, and execution-related configuration.

### Explicit and Implicit Waits
Used Selenium waits to handle synchronization between browser actions and dynamic web elements.

### Screenshot Handling
Implemented screenshot functionality to capture browser screenshots for debugging and failure investigation.

### Maven Build Management
Used Maven to manage project dependencies and execute the automation test suite.

### Jenkins CI Integration
Integrated the Selenium Maven project with Jenkins using a Freestyle Project. Configured source code management through GitHub and Maven test execution through Jenkins.

---

## 5. Automated Test Scenarios

The framework covers important e-commerce workflows:

| Module | Test Scenarios |
|---|---|
| Registration | New user registration and validation |
| Login | Valid and invalid login scenarios |
| Search | Product search functionality |
| Product | Product-related functionality |
| Cart | Shopping cart operations |
| Wishlist | Wishlist functionality |
| Checkout | Checkout workflow |

The test suite is designed to validate both individual application features and important user workflows.

---

## 6. Project Execution Workflow

The framework execution follows this process:

1. Read application and browser configuration.
2. Initialize the WebDriver.
3. Navigate to the application.
4. Execute TestNG test methods.
5. Interact with application pages through page classes.
6. Perform assertions to validate expected results.
7. Capture screenshots when required.
8. Generate test execution results.
9. Close the browser after execution.

---

## 7. How to Run the Project

### Prerequisites

Install the following tools:

- Java JDK 8 or compatible configured JDK.
- Eclipse or IntelliJ IDEA.
- Maven.
- Chrome or Microsoft Edge browser.
- Git.

### Step 1: Clone the Repository

```bash
git clone https://github.com/omkarautomation09/OctFramework.git
```

### Step 2: Open the Project

Import the project into Eclipse or IntelliJ IDEA as an existing Maven project.

### Step 3: Update Maven Dependencies

Run:

```bash
mvn clean install
```

### Step 4: Configure the Application

Update the configuration properties file with the required application URL, browser, and timeout settings.

### Step 5: Execute Automation Tests

Run the complete test suite using:

```bash
mvn clean test
```

You can also execute the configured TestNG XML suite from your IDE.

---

## 8. Jenkins CI Integration

The project is configured for execution through Jenkins.

**CI execution workflow:**

1. Source code is maintained in GitHub.
2. Jenkins connects to the GitHub repository.
3. Jenkins checks out the configured branch.
4. Maven executes the automation test suite.
5. Jenkins displays the build and test execution status.

Poll SCM can be configured to periodically check the repository for new commits and trigger a build when changes are detected.

This provides practical experience with continuous integration and automated test execution.

---

## 9. Skills Demonstrated Through This Project

- Java programming and OOP concepts.
- Selenium WebDriver automation.
- XPath and web element interaction.
- Page Object Model design pattern.
- TestNG test execution.
- Data-driven testing.
- Excel test data handling using Apache POI.
- Configuration management.
- Selenium synchronization and waits.
- Maven dependency and build management.
- Git and GitHub version control.
- Jenkins CI integration.
- Automated functional testing.

---

## 10. Project Objective

The objective of this project is to demonstrate practical knowledge of designing and implementing a Selenium automation framework using industry-relevant tools and practices.

The framework focuses on maintainability, reusability, structured test execution, and integration with a CI environment.

**Author:** Omkar Gaikwad

**Role:** Automation Testing / Selenium with Java

**Repository:** https://github.com/omkarautomation09/OctFramework
