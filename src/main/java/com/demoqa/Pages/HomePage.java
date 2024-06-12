package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private static final By ALERTS_FRAME_WINDOW_CARD = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    private static final By INTERACTIONS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Interactions']");
    private static final By BOOK_STORE_CARD = By.xpath("//div[@class='accordion']/div[6]//div[text()='Book Store Application']");

    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementsCard() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();
    }

    public void clickAlertsFrameWindowCard() {
        WebElement alertsFrameWindowElement = driver.findElement(ALERTS_FRAME_WINDOW_CARD);
        alertsFrameWindowElement.click();
    }

    public void clickInteractionsCard() {
        WebElement interactionsElement = driver.findElement(INTERACTIONS_CARD);
        interactionsElement.click();
    }

    public void clickOnBookStoreApplicationCard() {
        WebElement bookStoreApplicationCard = driver.findElement(BOOK_STORE_CARD);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", bookStoreApplicationCard);
        bookStoreApplicationCard.click();
    }
}
