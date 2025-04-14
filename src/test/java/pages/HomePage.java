package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "mainFrame")
  public WebElement iframeElement;

  @FindBy(id = "sideMenu")
  public WebElement sideMenu;
  
  @FindBy(id = "newDocument")
  public WebElement newDocumentButton;

  @FindBy(css = "#qtip-0-content font:first-of-type")
  public WebElement electricDocumentLabel;
}