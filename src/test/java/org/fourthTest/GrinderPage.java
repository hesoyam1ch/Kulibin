package org.fourthTest;

;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class GrinderPage<expected> {
    public WebDriver driver;
    @FindBy(xpath = "//a[@class='btn-blue show-more-link']")
    private WebElement showMore;

    int randomValue = getRandomNumberUsingInts(0, 10);
    int maxValue = 10;
    List<String> elText;
    List<Integer> discount;
    List<Integer> oldPrice;
    List<Integer> price;
    List<Integer> listActualPrice;
    List<String> nameText;
    List<WebElement> targetName;

    public GrinderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.discount = new ArrayList<>();
        this.oldPrice = new ArrayList<>();
        this.price = new ArrayList<>();
        this.listActualPrice = new ArrayList<>();
        this.nameText = new ArrayList<>();
        this.targetName = new ArrayList<>();
        this.elText = new ArrayList<>();
    }

    private void goToCategory(String categoryName) {

        var cssSelector = String.format("[title='%s']", categoryName);
        WebElement goToGrinder = driver.findElement(By.cssSelector(cssSelector));

        Actions actions = new Actions(driver);
        actions.moveToElement(goToGrinder).click().build().perform();
    }

    public void clickToGrinder() {
        goToCategory("Болгарки");
    }

    public void clickToShowMore() {

        try {
            showMore.click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void elementDiscount() {
        List<WebElement> target = driver.findElements(By.xpath("//span[contains(@class, 'stick-list__span image_sticker_discount_span')]"));
        Collections.shuffle(target, new Random());
        for (int i = 0; i < maxValue; i++) {
            String discElement = target.get(randomValue).getText();
            int tmp;
            try {
                tmp = Integer.parseInt(target.get(i).getText());
                discount.set(i, tmp);

                System.out.println(discount);

            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }

    }

    public void elementOldPrice() {
        List<WebElement> oldTarget = driver.findElements(By.xpath(
                "//span[contains(@class, 'stick-list__span image_sticker_discount_span')]/ancestor::div[@class='holder']/descendant::span[@class='old-price']"));
        Collections.shuffle(oldTarget, new Random());
        for (int i = 0; i < maxValue; i++) {
            String oldElement = oldTarget.get(randomValue).getText();
            int tmp;
            try {
                tmp = Integer.parseInt(oldTarget.get(i).getText());
                oldPrice.set(i, tmp);
                System.out.println(oldPrice);

            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
    }

    public void elementActual() {
        List<WebElement> targetActual = driver.findElements(By.xpath
                ("//span[contains(@class, 'stick-list__span image_sticker_discount_span')]/ancestor::div[@class='holder']/descendant::span[@class='price']"));
        Collections.shuffle(targetActual, new Random());
        for (int i = 0; i < maxValue; i++) {
            String elText = targetActual.get(randomValue).getText();
            int tmp;
            try {
                tmp = Integer.parseInt(targetActual.get(i).getText());
                price.set(i, tmp);
                System.out.println(price);

            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
    }

    public void elementName() {
        List<WebElement> targetName = driver.findElements
                (By.xpath("//span[contains(@class, 'stick-list__span image_sticker_discount_span')]/ancestor::div[@class='holder']//a[@class='title google_detail_link']"));
        Collections.shuffle(targetName, new Random());
        for (int i = 0; i < maxValue; i++) {
            elText.add(i, targetName.get(randomValue).getText());
        }
    }

    public void test() {
        for (Integer i : discount) {
            System.out.println(discount);
        }

    }

    public void normalPrice() {
        for (Integer element : discount) {
            var tmp = discount.get(element);

            for (Integer elementSecond : oldPrice) {

                double realyProcent = tmp / 100;
                var oldPriceTmp = oldPrice.get(element);
                var cash = oldPriceTmp * realyProcent;
                var normalPrice = oldPriceTmp - cash;
                listActualPrice.add(element, (int) normalPrice);
                System.out.println(listActualPrice);
            }
        }
    }


    public void result() {
        assertArrayEquals(String.valueOf(elText.size()), price.size(), listActualPrice.size());
    }

    private void assertArrayEquals(String s, Integer integer, Integer integer1) {
    }

    public int getRandomNumberUsingInts(int min, int max) { //max 15
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
