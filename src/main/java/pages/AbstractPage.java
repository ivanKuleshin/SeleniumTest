package pages;

import driver.DriverProvider;
import exceptions.TestExecutionException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.PropertiesProvider;

import static utils.WaitUtils.getDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver = DriverProvider.getInstance();
    protected PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();

    public AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitAndClick(WebElement elementToClick) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
    }

    public WebElement getElementByName(String elementName) {
        try {
            return (WebElement) FieldUtils.readField(this, elementName, true);
        } catch (IllegalAccessException exception) {
            // TODO: should be replaced by logger
            exception.printStackTrace();
            throw new TestExecutionException(
                    "Element '%s' was not found on the '%s' page", elementName, this.getClass());
        }
    }
}
