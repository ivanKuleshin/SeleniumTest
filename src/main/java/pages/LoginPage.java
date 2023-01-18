package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

  public void openLoginPage() {
    navigateTo(propertiesProvider.getProperty("loginPageUrl"));
  }

  public void clickLoginButton() {
    waitAndClick(loginButton);
  }

  public void enterUserName(String userName) {
    waitAndType(userNameInput, userName);
  }

  public void enterPassword(String userPassword) {
    waitAndType(userPasswordInput, userPassword);
  }
}
