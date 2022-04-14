package org.thirdTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.firstTest.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.secondTest.DrillPage;

import java.util.concurrent.TimeUnit;


public class ScrewdriversTest {
    public static ScrewdriversPage screwdriversPage;
    public static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("startPage"));
        screwdriversPage = new ScrewdriversPage(driver);
    }

    @Test
    public void ScrewdriversTest() {
        screwdriversPage.clickToScrewdrivers();
        screwdriversPage.checkAvailabilityUsaFlag();
        screwdriversPage.goToNextPage();
        screwdriversPage.checkAvailabilityUsaFlag();
        screwdriversPage.goToNextPage();
        screwdriversPage.checkAvailabilityUsaFlag();
    }
    @BeforeClass
    public static void end()
    {
        driver=new ChromeDriver();
        driver.quit();
    }
}
