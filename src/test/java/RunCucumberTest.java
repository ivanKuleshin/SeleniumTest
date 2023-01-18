import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"stepDefinitions"},
    tags = "(@regression and (not @ignore))",
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
