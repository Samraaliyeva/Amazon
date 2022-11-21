package TestCases;

import Utilities.WebDriverFactory;
import Utilities.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class testProperties {

    @Test
    public void t1(){

        String browserType= ConfigurationReader.get("browser");
        System.out.println("browser tupe is " + browserType);

        String url= ConfigurationReader.get("url1");
       // WebDriver driver=WebDriverFactory
    }
    @Test
    public void  open (){

        WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url1"));
    }
}
