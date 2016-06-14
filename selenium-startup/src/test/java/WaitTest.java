import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * YUAN
 * 6/14/16.
 */
public class WaitTest {

    @BeforeClass
    public static void before() {
//        System.setProperty("webdriver.chrome.driver", "/Users/YUAN/Project/Selenium/selenium-startup/src/main/resources/webdriver/chromedriver");
    }

    @Test
    public void t1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://cn.bing.com");
        WebElement queryWebElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("sb_form_q")));
        queryWebElement.sendKeys("GitHub");
        queryWebElement.submit();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void t2() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://cn.bing.com");
        WebElement queryWebElement = driver.findElement(By.id("sb_form_q"));
        queryWebElement.sendKeys("GitHub");
        queryWebElement.submit();
        Thread.sleep(5000);
        driver.quit();
    }

}
