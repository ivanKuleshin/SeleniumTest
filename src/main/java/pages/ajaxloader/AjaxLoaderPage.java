package pages.ajaxloader;

import exceptions.TestExecutionException;
import lombok.Getter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WaitUtils;

@Getter
public class AjaxLoaderPage extends BasePage {

  @FindBy(id = "loader")
  private WebElement ajaxLoader;

  @FindBy(id = "button1")
  private WebElement clickMeButton;

  private final ModalPopUp modalPopUp;

  public AjaxLoaderPage() {
    super();
    this.modalPopUp = new ModalPopUp();
  }

  @Override
  public void openPage() {
    navigateTo(propertiesProvider.getProperty("ajaxLoaderPageUrl"));
  }

  @Override
  public void pageIsValid() {
    try {
      WaitUtils.getDriverWait().until(ExpectedConditions.invisibilityOf(ajaxLoader));
    } catch (TimeoutException timeoutException) {
      // TODO: should be replaced by logger
      System.out.println(timeoutException.getMessage());
      throw new TestExecutionException(PAGE_IS_NOT_VALID_MESSAGE, this.getClass().getSimpleName());
    }
  }
}
