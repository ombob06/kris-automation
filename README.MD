# 🚀 kris-automation

**kris-automation** is an automated testing project built using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, and **Allure Reports**. This framework is designed to perform end-to-end testing of web-based applications — particularly for QA validations in Forest-related systems.

It includes a complete CI/CD integration using **GitHub Actions**, and supports easy test execution, reporting, and environment setup.

---

## 📦 Technology Stack

| Tool          | Purpose                                     |
|---------------|---------------------------------------------|
| Java 17       | Programming language                        |
| Selenium      | Web automation framework                    |
| Cucumber      | BDD testing framework (Gherkin syntax)      |
| Maven         | Build and dependency management             |
| Allure        | Test reporting and result visualization     |
| GitHub Actions| CI/CD for automated test execution          |

---

## ✅ How to Set Up and Run the Tests

### 1. Clone the Project

```bash
git clone git@github.com:Kriangga/kris-automation.git
cd kris-automation
```

### 2. Run tests locally
Make sure you have:
	•	Java 17+
	•	Maven
	•	Chrome installed

```bash
mvn clean test
```

### 3. Generate and View Allure Report
After running the tests:
```bash
mvn allure:report
allure serve target/site/allure-maven-plugin
```

If you don’t have the Allure CLI installed:
```bash
brew install allure
```

## Video Demonstration
1. [Filing with valid PDF and clicking Save](https://drive.google.com/file/d/1qYSxclsAWujWpQq3vRVZbmXxLd9Z062t/view?usp=sharing)
2. [Filing with Valid PDF Record and Clicking Save as Draft](https://drive.google.com/file/d/19SDFhWjxvJhtYqT2uG3OEgohEAiNCuz6/view?usp=drive_link)
3. [Filing an Existing Record to the Same Folder](https://drive.google.com/file/d/1ztOYFCRYMGezlxys7Hi7YVO8o4YXMqbv/view?usp=drive_link)