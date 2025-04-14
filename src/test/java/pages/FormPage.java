package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;

public class FormPage {
  WebDriver driver;

  public FormPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "select2-docHtmlTemplateId-container")
  public WebElement templateDropdown;

  @FindBy(css = "[id^='select2-docHtmlTemplateId-result-']")
  public List<WebElement> templateOption;
  
  public WebElement uploadDocButton() {
    return driver.findElement(By.cssSelector("input[type='file']#uploadDocu"));
  };

  @FindBy(id = "idBtnFileRef")
  public WebElement folderButton;

  @FindBy(id = "keywords1")
  public WebElement keywordsField;

  @FindBy(id = "synopsis1")
  public WebElement synopsisField;

  @FindBy(css = "a.buttonL.bGreen.send-right[title='Save']")
  public WebElement saveButton;

  @FindBy(css = "a.buttonL.bYellow.send-left[title='Save As Draft']")
  public WebElement saveAsDraftButton;

  @FindBy(css = "div#dialog-message.ui-dialog-content.ui-widget-content")
  public WebElement messageDialog; //The record is registered successfully.
}