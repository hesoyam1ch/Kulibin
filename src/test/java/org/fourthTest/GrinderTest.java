package org.fourthTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.firstTest.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GrinderTest {
    public static WebDriver driver;
    public static GrinderPage grinderPage;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("startPage"));
        grinderPage=new GrinderPage(driver);
    }
    @Test
    public void grinderTest() {
        int x=0;
        grinderPage.clickToGrinder();
        while(x<3) {
            grinderPage.clickToShowMore();
            x++;
        }
        grinderPage.elementDiscount();
        grinderPage.elementActual();
        grinderPage.elementOldPrice();
        grinderPage.elementName();
        grinderPage.normalPrice();
        grinderPage.result();
    }
    @AfterClass
    public static void end() {
        driver= new ChromeDriver();
        driver.quit();
    }
}
