package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "userId")
  public WebElement usernameField;

  @FindBy(id = "password")
  public WebElement passwordField;

  @FindBy(id = "submitButton")
  public WebElement loginButton;
}