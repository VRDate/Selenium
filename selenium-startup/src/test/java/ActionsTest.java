import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * YUAN
 * 6/14/16.
 */
public class ActionsTest {

    @Test
    public void t1() throws InterruptedException {
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setEnableNativeEvents(true);
        WebDriver driver = new ChromeDriver();
        driver.get("http://cn.bing.com");
        Actions builder = new Actions(driver);
        WebElement leftButton = driver.findElement(By.id("sh_lt"));
        WebElement rightButton = driver.findElement(By.id("sh_rt"));

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
