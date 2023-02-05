package pages;

import com.google.common.collect.ImmutableMap;
import driver.DriverProvider;
import exceptions.TestExecutionException;
import pages.contactus.ContactUsPage;
import pages.login.LoginPage;

import java.util.Map;

import static org.openqa.selenium.support.PageFactory.*;

public class SimplePageFactory {
  private static final Map<String, Class<? extends BasePage>> PAGES =
      new ImmutableMap.Builder<String, Class<? extends BasePage>>()
          .put("ContactUsPage", ContactUsPage.class)
          .put("LoginPage", LoginPage.class)
          .build();

  public static BasePage getPage(String pageName) {
    if (PAGES.containsKey(pageName)) {
      return initElements(DriverProvider.getInstance(), PAGES.get(pageName));
    } else {
      throw new TestExecutionException("'%s' is not defined in the PageFactory", pageName);
    }
  }
}
