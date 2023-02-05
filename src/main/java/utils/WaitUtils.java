package utils;

import driver.DriverProvider;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesProvider;

import java.time.Duration;

import static java.lang.Long.parseLong;

public class WaitUtils {
  public static final Long DEFAULT_TIMEOUT =
      parseLong(PropertiesProvider.getInstance().getProperty("defaultWaitTime"));

  public static WebDriverWait getDriverWait() {
    return new WebDriverWait(DriverProvider.getInstance(), Duration.ofSeconds(DEFAULT_TIMEOUT));
  }

  public static FluentWait<WebDriver> getDriverFluentWait(long timeout, long interval) {
    return new WebDriverWait(DriverProvider.getInstance(), Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(interval))
        .withMessage("Timeout occurred!")
        .ignoring(NoSuchElementException.class);
  }
}
