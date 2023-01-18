package utils;

import driver.DriverProvider;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesProvider;

import java.time.Duration;

import static java.lang.Long.parseLong;

public class WaitUtils {
  public static final Long DEFAULT_TIMEOUT =
      parseLong(PropertiesProvider.getInstance().getProperty("defaultWaitTime"));

  public static WebDriverWait getDriverWait() {
    return new WebDriverWait(
        DriverProvider.getInstance(), Duration.ofSeconds(DEFAULT_TIMEOUT));
  }
}
