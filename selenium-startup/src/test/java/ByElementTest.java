import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
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

    @Test
    public void t2() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

    @Test
    public void t3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = driver.findElement(By.tagName("p"));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

}
