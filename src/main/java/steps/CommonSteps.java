package steps;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.getDriverWait;

public class CommonSteps {
  public void sendKeys(WebElement webElement, String textToType) {
    getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);
  }

  public static String waiForAlertAndGetText() {
    getDriverWait().until(ExpectedConditions.alertIsPresent());
    return DriverProvider.getInstance().switchTo().alert().getText();
  }
}
