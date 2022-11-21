package TestCases;

import Hooks.TestBase;
import Utilities.ConfigurationReader;
import org.junit.jupiter.api.Test;

public class second extends TestBase {

   @Test
    public void m(){
       driver.get(ConfigurationReader.get("url1"));
   }


}
