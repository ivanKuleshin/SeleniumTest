package stepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.SimplePageFactory;

import static utils.WaitUtils.getDriverWait;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
