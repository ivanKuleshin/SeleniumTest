package pages.ajaxloader;

import exceptions.TestExecutionException;
import lombok.Getter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.BasePopUp;
import utils.WaitUtils;

@Getter
public class ModalPopUp extends BasePopUp {

    @FindBy(className = "modal-header")
    private WebElement popUpHeader;
    @FindBy(className = "modal-body")
    private WebElement popUpBody;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement closePopUpButton;

    public ModalPopUp() {
        super();
    }

  @Override
  public void waitUntilVisible() {
    try {
      ExpectedCondition<Boolean> expectedCondition = condition -> popUpHeader.isDisplayed();
      WaitUtils.getDriverWait().until(expectedCondition);
    } catch (TimeoutException timeoutException) {
      throw new TestExecutionException(POPUP_IS_NOT_VISIBLE_MESSAGE, this.getClass().getSimpleName());
    }
  }

  @Override
  public void waitUntilInvisible() {
    try {
      ExpectedCondition<Boolean> expectedCondition = condition -> !popUpHeader.isDisplayed();
      WaitUtils.getDriverWait().until(expectedCondition);
    } catch (TimeoutException timeoutException) {
      throw new TestExecutionException(POPUP_IS_VISIBLE_MESSAGE, this.getClass().getSimpleName());
    }
  }
}
