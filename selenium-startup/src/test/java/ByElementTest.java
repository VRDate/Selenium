import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
        WebDriver driver = new HtmlUnitDriver(true);
        // WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = driver.findElement(By.tagName("p"));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

    /*
    网上一些资料说显式比隐式要好，隐式全局，查找每一个元素都要浪费时间，影响性能，但从测试结果上来说并没有相差太多，而且隐式也是智能等待的，当所需要找的元素出现时立即下一步，而且不浪费时间
    但显式等待与隐式等待有一些区别:
    1. 显示等待是更加有针对性的的某一个特定的元素，是局部的，易于理解
    2. 隐示等待是全局的，全局只要写一次，每当需要找元素时都会调用该隐式等待，如果元素出来的快则快，出来的慢就需要慢慢等
    3. 由于显示等待考虑的是个体，所以根据个体来考虑设置时间，而隐式等待需要考虑到的整个sessiion所有元素的时间，所以在设置时只能设置一个最大值，否则有些需要等待的元素会报超时
    4. 从性能上说，相差无己; 从设计上说，显示等待更加合理; 从偷懒角度上说，隐式等待更加一劳永逸
     */


    /**
     * Explicit Waits 显式等待
     * <p>
     * An explicit wait is code you define to wait for a certain condition to occur before proceeding further in the code
     * <p>
     * 显式等待指的是需要明确指定一个等待的条件，如果这个条件成立，则结束等待，如果过了一定的时间后，等待(轮循)条件还不成立则报超时
     */
    @Test
    public void t2() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

    /**
     * Implicit Waits 隐式等待
     * <p>
     * An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately avaliable
     * <p>
     * 隐式等待指的是当查找元素时默认等待一定的时间，如果在这段时间内找到了元素，则程序继续进行，不一定要等到所规定的时间结束，如果过了这段时间还没有找到元素则返回超时错误
     */
    @Test
    public void t3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.navigate().to("file:///Users/YUAN/Project/Selenium/selenium-startup/src/test/resources/test.html");
        WebElement el = driver.findElement(By.tagName("p"));
        assertEquals(el.getText(), "Hello from JavaScript!");
        driver.quit();
    }

    /**
     * FluentWait
     */
    @Test
    public void t4() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
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
