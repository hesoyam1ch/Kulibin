package org.firstTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.secondTest.DrillPage;
import org.secondTest.DrillTest;

import java.util.concurrent.TimeUnit;

public class ProductTest {
    public static ProductTest productTest;
    public static ProductPage productPage;
    public static ElementPage elementPage;
    public static DrillPage drillPage;
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

        productPage = new ProductPage(driver);
        elementPage = new ElementPage(driver);
    }

    @Test
    public void pageTest() {
        int numberChechkElements = 3;
        int x = 0;
        productPage.clickToPerf();
        while (x < numberChechkElements) {
            productPage.addToListCart();
            elementPage.checkAvailabilityPrice();
            elementPage.checkAvailabilityOldPrice();
            elementPage.backToProductPage();
            ++x;
        }
    }

    @AfterClass
    public static void end() {
        driver = new ChromeDriver();
        driver.quit();
    }
}
