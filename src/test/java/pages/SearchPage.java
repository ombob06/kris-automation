package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;

public class SearchPage {
  WebDriver driver;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "input.textFieldClass[name='searchCriteria']")
  public WebElement criteriaField;

  @FindBy(css = "input.buttonL.bGreen[value='Search']")
  public WebElement searchButton;

  // @FindBy(css = "input[name='fileRef']")
  @FindBy(css = "[id^='uniform-fileRefSysId']")
  public WebElement radioButton;

  @FindBy(css = "input.buttonL.bGreen.send-left[value='OK']")
  public WebElement okButton;
}