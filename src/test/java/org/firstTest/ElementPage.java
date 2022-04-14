package org.firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ElementPage {
    public WebDriver driver;

    public ElementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"bx_117848907_31003_price\"]")
    private WebElement price;
    @FindBy(xpath = "//*[@id=\"bx_117848907_31003_old_price\"]")
    private WebElement oldPrice;

    void checkAvailabilityPrice() {
        try {
            driver.findElement(By.cssSelector(".price"));
            System.out.println("price is found");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("price element not found");
        }
    }

    void checkAvailabilityOldPrice() {
        try {
            driver.findElement(By.xpath("//*[@id=\"bx_117848907_31003_old_price\"]"));
            System.out.println("Old Price found");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("old price not found");
        }
    }

    void backToProductPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
    }
}
