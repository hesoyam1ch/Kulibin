package org.thirdTest;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrewdriversPage {
    public WebDriver driver;


    public ScrewdriversPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void goToCategory(String categoryName) {

        var cssSelector = String.format("[title='%s']", categoryName);
        WebElement goToScrewdrivers = driver.findElement(By.cssSelector(cssSelector));

        Actions actions = new Actions(driver);
        actions.moveToElement(goToScrewdrivers).click().build().perform();
    }

    public void clickToScrewdrivers() {
        goToCategory("Шуруповерты");
    }

    public void checkAvailabilityUsaFlag() {
        List<WebElement> targetImages = driver.findElements(By.xpath("//img[contains(@src, 'United_states.jpg')]/../../../h4[@class='s_title']"));
        Collections.shuffle(targetImages, new Random());
        for (var element : targetImages) {
            var elClass = element.getText();
            System.out.println(elClass);
        }
    }

    public void goToNextPage() {
        driver.findElement(By.cssSelector("a.icon-catalogarrow2")).click();
    }


}
