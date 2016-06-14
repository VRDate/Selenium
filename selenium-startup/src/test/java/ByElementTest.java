import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * YUAN
 * 6/14/16.
 */
public class ByElementTest {

    @Test
    public void t1() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = driver.findElement(By.tagName("p"));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

}
