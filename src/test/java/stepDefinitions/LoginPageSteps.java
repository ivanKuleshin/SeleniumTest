package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.testng.Assert;
import pages.LoginPage;
import steps.CommonSteps;

@AllArgsConstructor
public class LoginPageSteps extends CommonSteps {
  private final LoginPage loginPage;

  @Given("I open login page")
  public void iOpenLoginPage() {
    loginPage.openLoginPage();
  }

  @When("I enter default user name")
  public void iEnterUserName() {
    loginPage.enterUserName(System.getenv("userName"));
  }

  @When("I enter user name: {string}")
  public void iEnterInvalidUserName(String userName) {
    loginPage.enterUserName(userName);
  }

  @And("I enter default user password")
  public void iEnterUserPassword() {
    loginPage.enterPassword(System.getenv("userPassword"));
  }

  @And("I enter user password: {string}")
  public void iEnterInvalidUserPassword(String userPassword) {
    loginPage.enterPassword(userPassword);
  }

  @And("I click login button")
  public void iCLickLoginButton() {
    loginPage.clickLoginButton();
  }

  @Then("I see the login message: {string}")
  public void verifyLoginMessage(String expectedMessage) {
    String actualMessage = waiForAlertAndGetText();
    Assert.assertEquals(actualMessage, expectedMessage);
  }
}
