# 🧪 OrangeHRM Automation Framework

This is a personal automation testing framework developed for [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) using **Selenium**, **Java**, and **Cucumber (BDD)**.

---

## 🚀 Project Overview

The framework automates core user management functionalities of OrangeHRM. It includes:

1. **Admin Login / Logout**
2. **Create New User**
   - Reads user data from an Excel file using Apache POI
   - Verifies user creation
   - Deletes the created user
3. **Login with Created User**

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- Cucumber (Gherkin BDD)
- Apache POI (for Excel data handling)
- Maven (Build Tool)
- JUnit / TestNG
- Properties File (for configuration)
- Cucumber Hooks (for driver lifecycle management)

---

## 📁 Project Structure

src/test/java
├── Featurefile # Contains all .feature files (Gherkin syntax)
├── PageObjects # Page Object Model classes for web elements and actions
├── resource # Excel test data file and properties file
├── runner # TestRunner class to execute scenarios
├── StepDefination # Step definitions for feature files + Hooks class for setup/teardown
└── Utils # Utilities like Excel Reader, Config Loader, General utility ( explicit wait ,scrolling )  etc.



---

## ⚙ Configuration

- `properties` file is used to manage:
  - Application URL (global.properties)
  - user detail (external.properties)
- `Excel` file contains dynamic user data used during user creation 

---

## 🧬 Cucumber Hooks

Hooks are used for browser setup and teardown:
- `@Before` - Initialize WebDriver
- `@After`  - Quit WebDriver

---

## 🧪 How to Run

Make sure all dependencies are installed via Maven.

