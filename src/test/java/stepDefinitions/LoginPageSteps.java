package stepDefinitions;

import io.cucumber.java.en.Given;
import lombok.AllArgsConstructor;
import pages.login.LoginPage;

@AllArgsConstructor
public class LoginPageSteps {
  //  PicoContainer dependency injection
  private final LoginPage loginPage;

  @Given("User performs login with default credentials")
  public void performLoginWithDefaultCredentials() {
    loginPage.enterUserName(System.getenv("userName"));
    loginPage.enterPassword(System.getenv("userPassword"));
  }
}
