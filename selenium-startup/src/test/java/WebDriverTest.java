import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * YUAN
 * 6/14/16.
 */
public class WebDriverTest {

    @Test
    public void t1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

// Waiting 30 seconds for an element to be present on the page, checking
// for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(10, SECONDS)
                .ignoring(NoSuchElementException.class);

        driver.get("http://cn.bing.com");

        WebElement leftButton = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("sh_lt"));
            }
        });

        WebElement rightButton = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("sh_rt"));
            }
        });


        Actions builder = new Actions(driver);

        Thread.sleep(5000);
        builder.click(leftButton).perform();
        Thread.sleep(5000);
        builder.click(rightButton).perform();
        Thread.sleep(5000);
        builder.click(leftButton).perform();
        Thread.sleep(5000);
        builder.click(rightButton).perform();
        Thread.sleep(5000);

        driver.quit();
    }

}
