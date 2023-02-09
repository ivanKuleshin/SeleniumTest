package pages.contactus;

import exceptions.TestExecutionException;
import lombok.Getter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WaitUtils;

@Getter
public class ContactUsPage extends BasePage {

  @FindBy(xpath = "//h2[@name='contactme']")
  private WebElement pageHeading;

  @FindBy(name = "first_name")
  private WebElement firstNameInput;
  @FindBy(name = "last_name")
  private WebElement lastNameInput;
  @FindBy(name = "email")
  private WebElement emailInput;
  @FindBy(name = "message")
  private WebElement commentInput;

  @FindBy(xpath = "//input[@type='submit']")
  private WebElement submitButton;

  @FindBy(xpath = "//div[@id='contact_reply']/h1")
  private WebElement submissionMessage;

  public ContactUsPage() {
    super();
  }

  @Override
  public void openPage() {
    navigateTo(propertiesProvider.getProperty("contactUsUrl"));
    waitForPageLoad();
    pageIsValid();
  }

  @Override
  public void pageIsValid() {
    try {
      WaitUtils.getDriverWait().until(ExpectedConditions.visibilityOf(pageHeading));
    } catch (TimeoutException timeoutException) {
      // TODO: should be replaced by logger
      System.out.println(timeoutException.getMessage());
      throw new TestExecutionException(PAGE_IS_NOT_VALID_MESSAGE, this.getClass().getSimpleName());
    }
  }
}
