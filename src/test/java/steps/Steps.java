package steps;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import java.time.Duration;
import java.io.File;
import pages.LoginPage;
import pages.HomePage;
import pages.FormPage;
import pages.SearchPage;

public class Steps {
  WebDriver driver;
  WebDriverWait wait;
  LoginPage loginPage;
  HomePage homePage;
  FormPage formPage;
  SearchPage searchPage;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://krisdemo.sqlview.com.sg/KRIS/login.do?method=reloadLogin");
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Given("user logs in with username {string} and password {string}")
  public void login(String username, String password) {
    loginPage = new LoginPage(driver);
    loginPage.usernameField.sendKeys(username);
    loginPage.passwordField.sendKeys(password);
    loginPage.loginButton.click();
  }

  @When("user navigate to document filling form")
  public void fillingForm() {
    homePage = new HomePage(driver);
    wait.until(ExpectedConditions.visibilityOf(homePage.iframeElement));
    driver.switchTo().frame(homePage.iframeElement);
    homePage.newDocumentButton.click();
    wait.until(ExpectedConditions.visibilityOf(homePage.electricDocumentLabel)).click();
  }

  @And("select template {string} as the template from the template selection options and upload document {string}")
  public void uploadDocument(String template, String document) {
    formPage = new FormPage(driver);
    wait.until(ExpectedConditions.visibilityOf(formPage.templateDropdown)).click();
    if (template.equals("default")) {
      formPage.templateOption.get(1).click();
    }
    File uploadFile = new File("src/test/resources/fixtures/" + document);
    try {
      wait.until(ExpectedConditions.visibilityOf(formPage.uploadDocButton()));
    } catch(StaleElementReferenceException e) {
      formPage.uploadDocButton().sendKeys(uploadFile.getAbsolutePath());
    }
  }

  @And("user search and select folder {string}")
  public void searchFolder(String folder) {
    formPage = new FormPage(driver);
    try {
      formPage.folderButton.click();
    } catch(StaleElementReferenceException e) {
      formPage.folderButton.click();
    }
    String originalWindow = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
      if (!windowHandle.equals(originalWindow)) {
          driver.switchTo().window(windowHandle);
          break;
      }
    }
    searchPage = new SearchPage(driver);
    wait.until(ExpectedConditions.visibilityOf(searchPage.criteriaField)).sendKeys(folder);
    wait.until(ExpectedConditions.visibilityOf(searchPage.searchButton)).click();
    try {
      searchPage.radioButton.click();
    } catch(StaleElementReferenceException e) {
      searchPage.radioButton.click();
    }
    // wait.until(ExpectedConditions.visibilityOf(searchPage.radioButton)).click();
    wait.until(ExpectedConditions.visibilityOf(searchPage.okButton)).click();
    driver.switchTo().window(originalWindow);
  }

  @And("user fill field Keywords {string} and field Synopsis {string}")
  public void fillField(String keywords, String synopsis) {
    formPage = new FormPage(driver);
    homePage = new HomePage(driver);
    wait.until(ExpectedConditions.visibilityOf(homePage.iframeElement));
    driver.switchTo().frame(homePage.iframeElement);
    wait.until(ExpectedConditions.visibilityOf(formPage.keywordsField)).sendKeys(keywords);
    wait.until(ExpectedConditions.visibilityOf(formPage.synopsisField)).sendKeys(synopsis);
  }

  @And("user save the form")
  public void saveForm() {
    formPage = new FormPage(driver);
    wait.until(ExpectedConditions.visibilityOf(formPage.saveButton)).click();
  }

  @And("user save as draft the form")
  public void saveAsDraftForm() {
    formPage = new FormPage(driver);
    wait.until(ExpectedConditions.visibilityOf(formPage.saveAsDraftButton)).click();
  }

  @Then("system shows {string}")
  public void validateMessage(String expectedMessage) {
    driver.switchTo().defaultContent();
    formPage = new FormPage(driver);
    wait.until(ExpectedConditions.visibilityOf(formPage.messageDialog));
    Assert.assertEquals(expectedMessage, formPage.messageDialog.getText());
  }
}