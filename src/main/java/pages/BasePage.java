package pages;

import exceptions.TestExecutionException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtils;

import static utils.WaitUtils.getDriverWait;

public abstract class BasePage extends AbstractPage{
  protected static final String PAGE_IS_NOT_VALID_MESSAGE = "Page '%s' is NOT valid!";

  public BasePage() {
    super();
  }

  public abstract void openPage();
  public abstract void pageIsValid();

  public void navigateTo(String url) {
    driver.get(url);
  }

  public void waitAndType(WebElement webElement, String textToType) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);
  }

  public BasePopUp getPopUpByName(String popUpName) {
    try {
      return (BasePopUp) FieldUtils.readField(this, popUpName, true);
    } catch (IllegalAccessException exception) {
      // TODO: should be replaced by logger
      exception.printStackTrace();
      throw new TestExecutionException(
          "Element '%s' was not found on the '%s' page", popUpName, this.getClass());
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
