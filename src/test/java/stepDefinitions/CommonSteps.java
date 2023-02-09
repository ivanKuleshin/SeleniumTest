package stepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.BasePopUp;
import pages.SimplePageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.WaitUtils.getDriverWait;

public class CommonSteps {

  @Given("User types {string} value to {string} element on the {string} page")
  public void userTypesValueToElement(String valueToType, String elementName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    WebElement element = page.getElementByName(elementName);
    page.waitAndType(element, valueToType);
  }

  @Given("User performs default click on the {string} element on the {string} page")
  public void userPerformDefaultClick(String elementName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    WebElement elementToClick = page.getElementByName(elementName);
    page.waitAndClick(elementToClick);
  }

  @And("User performs default click on the {string} element in the {string} popUp on the {string} page")
  public void userPerformDefaultClickInPopUp(String elementName, String popUpName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    BasePopUp popUp = page.getPopUpByName(popUpName);
    WebElement elementToClick = popUp.getElementByName(elementName);

    popUp.waitAndClick(elementToClick);
  }

  @Then("User sees {string} element with a {string} text on the {string} page")
  public void verifyElementWithTextOnThePage(String elementName, String expectedText, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    WebElement elementFromPage = page.getElementByName(elementName);

    assertThat(elementFromPage.getText()).isEqualTo(expectedText);
  }

  @Then("User sees {string} element contains {string} text on the {string} page")
  public void verifyElementContainsText(String elementName, String expectedText, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    WebElement elementFromPage = page.getElementByName(elementName);

    assertThat(elementFromPage.getText()).contains(expectedText);
  }

  @And("User sees {string} popUp on the {string} page")
  public void waitPopUpIsVisible(String popUpName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);

    page.getPopUpByName(popUpName).waitUntilVisible();
  }

  @And("User doesn't see {string} popUp on the {string} page")
  public void waitPopUpIsNotVisible(String popUpName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);

    page.getPopUpByName(popUpName).waitUntilInvisible();
  }

  @Then("User sees {string} element contains {string} text in the {string} popUp on the {string} page")
  public void verifyPopUpElementContainsText(
      String elementName, String expectedText, String popUpName, String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    BasePopUp popUp = page.getPopUpByName(popUpName);
    WebElement elementFromPopUp = popUp.getElementByName(elementName);

    assertThat(elementFromPopUp.getText()).contains(expectedText);
  }

  @Then("User sees {string} text in the alert window")
  public void verifyTextInTheAlert(String expectedText) {
    getDriverWait().until(ExpectedConditions.alertIsPresent());
    String actualText = DriverProvider.getInstance().switchTo().alert().getText();

    assertThat(actualText).isEqualTo(expectedText);
  }

  @Given("User opens {string} page")
  public void openPage(String pageName) {
    SimplePageFactory.getPage(pageName).openPage();
  }

  @Given("User waits until {string} page will be loaded")
  public void waitPageForLoad(String pageName) {
    BasePage page = SimplePageFactory.getPage(pageName);
    page.waitForPageLoad();
    page.pageIsValid();
  }
}
