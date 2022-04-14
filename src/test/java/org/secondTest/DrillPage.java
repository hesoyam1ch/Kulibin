package org.secondTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class DrillPage {
    public WebDriver driver;

    public DrillPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void goToCategory(String categoryName) {

        var cssSelector = String.format("[title='%s']", categoryName);
        WebElement goToDrill = driver.findElement(By.cssSelector(cssSelector));

        Actions actions = new Actions(driver);
        actions.moveToElement(goToDrill).click().build().perform();
    }

    public void clickToDrill() {
        goToCategory("Дрели");
    }

    public void checkPrices() {
        try {
            List<WebElement> spanPrice = driver.findElements(By.cssSelector(".price"));
            for (int i=0;i<spanPrice.size();i++) {
                String price = spanPrice.get(i).getText();
            }
            System.out.println("price found");

        } catch (Exception e) {
            System.out.println("price not found");
        }
    }
    public void goToNextPage() {
        driver.findElement(By.cssSelector("a.icon-catalogarrow2")).click();
    }

}


