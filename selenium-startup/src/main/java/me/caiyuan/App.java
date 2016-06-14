package me.caiyuan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Value("${webDriverPath}")
    private String webDriverPath;

    @PostConstruct
    public void init() {
        System.getProperties().setProperty("webdriver.chrome.driver", webDriverPath);
    }

    @Override
    public void run(String... args) throws Exception {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://search.333job.com/");
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        // Thread.sleep(5000);
        webDriver.close();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}
