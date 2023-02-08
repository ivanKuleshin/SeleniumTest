package pages;

import driver.DriverProvider;
import exceptions.TestExecutionException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.PropertiesProvider;
import utils.WaitUtils;

import static utils.WaitUtils.getDriverWait;

public abstract class BasePage {
  protected WebDriver driver = DriverProvider.getInstance();
  protected PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();

  public BasePage() {
    PageFactory.initElements(driver, this);
  }

  public abstract void openPage();

  public abstract void pageIsValid();

  public void navigateTo(String url) {
    driver.get(url);
  }

  public void waitAndClick(WebElement elementToClick) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
  }

  public void waitAndType(WebElement webElement, String textToType) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);
  }

  public WebElement getElementByName(String elementName) {
    try {
      return (WebElement) FieldUtils.readField(this, elementName, true);
    } catch (IllegalAccessException exception) {
      // TODO: should be replaced by logger
      exception.printStackTrace();
      throw new TestExecutionException(
              "Element '%s' was not found on the '%s' page", elementName, this.getClass());
    }
  }

  public void waitForPageLoad() {
//    Another way:
//    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

    ExpectedCondition<Boolean> expectedCondition =
        condition ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete");

    WaitUtils.getDriverWait().until(expectedCondition);
  }
}
