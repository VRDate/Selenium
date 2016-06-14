import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * YUAN
 * 6/14/16.
 */
public class SeleniumTest {

    public static void main(String[] args) {
        // You may use any WebDriver implementation. Firefox is used here as an example
        WebDriver driver = new FirefoxDriver();

// A "base url", used by selenium to resolve relative URLs
        String baseUrl = "http://www.google.com";

// Create the Selenium implementation
        Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);

// Perform actions with selenium

        selenium.open("http://www.google.com");
        selenium.type("name=q", "cheese");
        selenium.click("name=btnG");

// Get the underlying WebDriver implementation back. This will refer to the
// same WebDriver instance as the "driver" variable above.
        WebDriver driverInstance = ((WebDriverBackedSelenium) selenium).getWrappedDriver();

//Finally, close the browser. Call stop on the WebDriverBackedSelenium instance
//instead of calling driver.quit(). Otherwise, the JVM will continue running after
//the browser has been closed.
        selenium.stop();
    }

}
