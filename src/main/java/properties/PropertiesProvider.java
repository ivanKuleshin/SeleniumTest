package properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class PropertiesProvider {

  private static final Properties PROPERTIES = new Properties();
  private static PropertiesProvider propertiesProvider;

  private static final String VALUE_FROM_BRACES_REGEX = "(?<=\\$\\{).+?(?=})";
  private static final String VALUE_WITH_BRACES_REGEX = "\\$\\{\\w+}";

  private PropertiesProvider() {
    this.initializeProperties();
  }

  public static PropertiesProvider getInstance() {
    if (propertiesProvider == null) {
      propertiesProvider = new PropertiesProvider();
    }
    return propertiesProvider;
  }

  public String getProperty(String propertyName) {
    return resolveProperty(PROPERTIES.getProperty(propertyName));
  }

  private void initializeProperties() {
    String path = System.getProperty("properties.path");
    try {
      PROPERTIES.load(new FileReader(ofNullable(path).orElse(EMPTY)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String resolveProperty(String propertyValue) {
    Pattern pattern = Pattern.compile(VALUE_FROM_BRACES_REGEX);
    Matcher matcher = pattern.matcher(propertyValue);

    List<String> variableList = new ArrayList<>();
    while (matcher.find()) {
      variableList.add(matcher.group());
    }

    for (String variableName : variableList) {
      propertyValue = propertyValue.replaceFirst(VALUE_WITH_BRACES_REGEX, getProperty(variableName));
    }
    return propertyValue;
  }
}
