package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ContactUsPage extends BasePage {

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

  public void openContactUsPage() {
    navigateTo(propertiesProvider.getProperty("contactUsUrl"));
  }

  public void clickSubmitButton() {
    waitAndClick(submitButton);
  }
}
