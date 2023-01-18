package driver;

import driver.managers.AbstractDriverManager;
import driver.managers.ChromeDriverManager;
import driver.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverProvider {
  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private DriverProvider() {
    driver.set(createDriver(System.getProperty("browser")).createDriver());
  }

  public static WebDriver getInstance() {
    if (driver.get() == null) {
      driver.set(new DriverProvider().getDriver());
    }
    return driver.get();
  }

  public static void removeInstance() {
    driver.set(null);
  }

  public WebDriver getDriver() {
    return driver.get();
  }

  private static AbstractDriverManager createDriver(String browserName) {
    if ("edge".equals(browserName)) {
      return new EdgeDriverManager();
    } else {
      return new ChromeDriverManager();
    }
  }
}
