package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.PropertiesProvider;
import utils.WaitUtils;

import static utils.WaitUtils.getDriverWait;

public class BasePage {
  protected WebDriver driver = DriverProvider.getInstance();
  protected PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();

  public BasePage() {
    PageFactory.initElements(driver, this);
  }

  public void navigateTo(String url) {
    driver.get(url);
  }

  public void waitAndClick(WebElement elementToClick) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
  }

  public void waitAndType(WebElement webElement, String textToType) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);
  }
}
