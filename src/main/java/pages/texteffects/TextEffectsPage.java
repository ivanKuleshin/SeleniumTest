package pages.texteffects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.WaitUtils;

@Getter
public class TextEffectsPage extends BasePage {
  private static final String LOADING_COMPLETED = "LOADING COMPLETE.";

  @FindBy(id = "main-header")
  private WebElement mainHeader;
  @FindBy(id = "text-appear-box")
  private WebElement loadingStatus;

  @FindBy(id = "manual-testing-accordion")
  private WebElement manualTestingAccordionMenuButton;
  @FindBy(id = "manual-testing-description")
  private WebElement manualTestingAccordionMenuDescription;

  @FindBy(id = "cucumber-accordion")
  private WebElement cucumberBddAccordionMenuButton;
  @FindBy(id = "cucumber-testing-description")
  private WebElement cucumberBddAccordionMenuDescription;

  @FindBy(id = "automation-accordion")
  private WebElement automationTestingAccordionMenuButton;
  @FindBy(id = "automation-testing-description")
  private WebElement automationTestingAccordionMenuDescription;

  @FindBy(id = "click-accordion")
  private WebElement keepClickingAccordionMenuButton;
  @FindBy(id = "timeout")
  private WebElement keepClickingAccordionMenuDescription;

  public TextEffectsPage() {
    super();
  }

  @Override
  public void openPage() {
    navigateTo(propertiesProvider.getProperty("textEffectsPageUrl"));
  }

  @Override
  public void pageIsValid() {
    WaitUtils.getDriverWait().until(ExpectedConditions.visibilityOf(mainHeader));

    ExpectedCondition<Boolean> expectedCondition =
            condition -> loadingStatus.getText().equals(LOADING_COMPLETED);
    WaitUtils.getDriverFluentWait(15, 1).until(expectedCondition);
  }
}
