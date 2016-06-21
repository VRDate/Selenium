import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * YUAN
 * 6/17/16.
 */
public class ZhiHuTest {

    private static WebDriver DRIVER;
    private static WebDriverWait WAIT;
    private static Actions ACTIONS;

    @BeforeClass
    public static void login() {
        DRIVER = new ChromeDriver();
        WAIT = new WebDriverWait(DRIVER, 30);
        ACTIONS = new Actions(DRIVER);

        DRIVER.get("http://www.zhihu.com/#signin");

        WebElement login = WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/a[2]")));
        ACTIONS.click(login).perform();
        WebElement username = WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[1]/input")));
        ACTIONS.sendKeys(username, "******");
        WebElement password = WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[2]/input")));
        ACTIONS.sendKeys(password, "******");
        WebElement submit = WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[2]/button")));
        ACTIONS.click(submit).perform();
    }

    @Test
    public void t1() throws Exception {
        SECONDS.sleep(15);

        Set<Cookie> cookies = DRIVER.manage().getCookies();

        DRIVER.quit();

        SECONDS.sleep(5);

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.zhihu.com/");
        for (Cookie cookie : cookies) {
            System.out.println(">>> " + cookie);
            driver.manage().addCookie(cookie);
        }
        driver.get("http://www.zhihu.com/");
    }

}
