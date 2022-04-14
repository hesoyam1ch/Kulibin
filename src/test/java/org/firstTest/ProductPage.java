package org.firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class ProductPage {
    public WebDriver driver;


    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public int getRandomNumberUsingInts(int min, int max) { //max 15
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public void addToListCart() {
        List<WebElement> carts = driver.findElements(By.cssSelector("h4.s_title"));
        Collections.shuffle(carts, new Random());
        carts.get(getRandomNumberUsingInts(0,15)).click();
    }

    private void goToCategory(String categoryName) {

        var cssSelector = String.format("[title='%s']", categoryName);
        WebElement goToPerforator = driver.findElement(By.cssSelector(cssSelector));

        Actions actions = new Actions(driver);
        actions.moveToElement(goToPerforator).click().build().perform();
    }

    public void clickToPerf() {
        goToCategory("Перфораторы");
    }

}
