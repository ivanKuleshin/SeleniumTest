package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.testng.Assert;
import pages.ContactUsPage;
import steps.CommonSteps;

@AllArgsConstructor
public class ContactUsSteps extends CommonSteps {
  private final ContactUsPage contactUsPage;

  @Given("I open the ContactUs page")
  public void iAccessTheWebDriverUniversityContactUsPage() {
    contactUsPage.openContactUsPage();
  }

  @When("I enter a unique first name")
  public void iEnterAUniqueFirstName() {
    sendKeys(contactUsPage.getFirstNameInput(), "Ivan");
  }

  @And("I enter a unique last name")
  public void iEnterAUniqueLastName() {
    sendKeys(contactUsPage.getLastNameInput(), "Ivanovich");
  }

  @And("I enter a unique email address")
  public void iEnterAUniqueEmailAddress() {
    sendKeys(contactUsPage.getEmailInput(), "ivan.test@gmail.com");
  }

  @And("I enter a unique comment")
  public void iEnterAUniqueComment() {
    sendKeys(contactUsPage.getCommentInput(), "My unique comment");
  }

  @And("I click on the submit button")
  public void iClickOnTheSubmitButton() {
    contactUsPage.clickSubmitButton();
  }

  @Then("I should be presented with a successful contact us submission message")
  public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
    String expectedMessage = "Thank You for your Message!";
    String actualMessage = contactUsPage.getSubmissionMessage().getText();

    Assert.assertEquals(actualMessage, expectedMessage);
  }

  @When("I enter a specific first name {string}")
  public void iEnterASpecificFirstNameJoe(String firstName) {
    sendKeys(contactUsPage.getFirstNameInput(), firstName);
  }

  @And("I enter a specific last name {string}")
  public void iEnterASpecificLastNameBlogs(String lastName) {
    sendKeys(contactUsPage.getLastNameInput(), lastName);
  }

  @And("I enter a specific email address {string}")
  public void iEnterASpecificEmailAddressJoe_blogsMailCom(String email) {
    sendKeys(contactUsPage.getEmailInput(), email);
  }

  @And("I enter a specific comment {string}")
  public void iEnterASpecificComment(String comment) {
    sendKeys(contactUsPage.getCommentInput(), comment);
  }
}
