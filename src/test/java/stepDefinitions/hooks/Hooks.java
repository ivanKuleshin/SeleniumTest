package stepDefinitions.hooks;

import driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

public class Hooks {

  @AfterStep
  public void captureScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      String timeMilliseconds = Long.toString(timestamp.getTime());

      byte[] screenshot =
          ((TakesScreenshot) DriverProvider.getInstance())
              .getScreenshotAs(OutputType.BYTES);

      scenario.attach(screenshot, "image/png", "screenshot" + timeMilliseconds);
    }
  }

  @After
  public void tearDown() {
    DriverProvider.getInstance().quit();
    DriverProvider.removeInstance();
  }
}
