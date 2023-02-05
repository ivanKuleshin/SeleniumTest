package pages.login;

import exceptions.TestExecutionException;
import lombok.Getter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WaitUtils;

@Getter
public class LoginPage extends BasePage {

  @FindBy(id = "text")
  private WebElement userNameInput;
  @FindBy(id = "password")
  private WebElement userPasswordInput;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  public LoginPage() {
    super();
  }

  @Override
  public void openPage() {
    navigateTo(propertiesProvider.getProperty("loginPageUrl"));
  }

  @Override
  public void pageIsValid() {
    try {
      WaitUtils.getDriverWait().until(ExpectedConditions.elementToBeClickable(loginButton));
    } catch (TimeoutException timeoutException) {
      // TODO: should be replaced by logger
      System.out.println(timeoutException.getMessage());
      throw new TestExecutionException("Page '%s' is not valid!", this.getClass().getSimpleName());
    }

  }

  public void enterUserName(String userName) {
    waitAndType(userNameInput, userName);
  }

  public void enterPassword(String userPassword) {
    waitAndType(userPasswordInput, userPassword);
  }
}
