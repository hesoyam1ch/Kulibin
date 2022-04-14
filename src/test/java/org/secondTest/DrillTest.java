package org.secondTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.firstTest.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DrillTest {
    public static DrillPage drillPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("startPage"));

        drillPage= new DrillPage(driver);
    }
    @Test
    public void drillTest(){
        drillPage.clickToDrill();
        drillPage.checkPrices();
        drillPage.goToNextPage();
        drillPage.checkPrices();

    }
    @AfterClass
    public static void end() {
        driver = new ChromeDriver();
        driver.quit();
    }
}
