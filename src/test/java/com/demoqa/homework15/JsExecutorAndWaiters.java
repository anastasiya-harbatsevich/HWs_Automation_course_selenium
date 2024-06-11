package com.demoqa.homework15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class JsExecutorAndWaiters {
    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private static final By BOOK_STORE_CARD = By.xpath("//div[@class='accordion']/div[6]//div[text()='Book Store Application']");


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void testLinkOpenedInNewTab() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement linksMenu = driver.findElement(By.id("item-5"));
        linksMenu.click();

        WebElement linkOpenedInNewTab = driver.findElement(By.id("simpleLink"));
        linkOpenedInNewTab.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(tabs.get(1));
        driver.get("https://demoqa.com/");
    }

    @Test
    void testScrollToBookStore() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement bookStoreApplicationCard = driver.findElement(BOOK_STORE_CARD);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", bookStoreApplicationCard);
        bookStoreApplicationCard.click();
    }

    @Test
    void testButtonVisibility() {

        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement dynamicPropertiesItem = driver.findElement(By.id("item-8"));
        dynamicPropertiesItem.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(textToBe(By.id("visibleAfter"), "Visible After 5 Seconds"));
    }
}
