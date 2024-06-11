package com.demoqa.homework16;

import com.demoqa.ConfigFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ActionsIframeProperties {

    private static final By ALERTS_FRAME_WINDOW_CARD = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    private static final By INTERACTIONS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Interactions']");
    private static final By NESTED_FRAMES_ITEM = By.xpath("//div[@class='accordion']/div[3]//div/ul/li[@id='item-3']");
    private static final By DROPPABLE_ITEM = By.xpath("//div[@class='accordion']/div[5]//div/ul/li[@id='item-3']");
    private static final By NESTED_FRAME_PARENT_IFRAME = By.id("frame1");
    private static final By NESTED_FRAMES_PARENT_TITLE = By.xpath("//html/body[text()='Parent frame']");
    private static final String NESTED_FRAMES_PARENT_TITLE_EXPECTED = "Parent frame";
    private static final String INTERACTIONS_RESULT_MESSAGE_EXPECTED = "Dropped!";
    private static final By INTERACTIONS_DRAGGABLE_ELEMENT = By.id("draggable");
    private static final By INTERACTIONS_DROPPABLE_ELEMENT = By.id("droppable");
    private static final By INTERACTIONS_RESULT_MESSAGE = By.id("droppable");
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        var configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void testIframe() {
        WebElement alertsFrameWindowElement = driver.findElement(ALERTS_FRAME_WINDOW_CARD);
        alertsFrameWindowElement.click();

        WebElement framesItem = driver.findElement(NESTED_FRAMES_ITEM);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", framesItem);

        var iFrame = driver.findElement(NESTED_FRAME_PARENT_IFRAME);
        driver.switchTo().frame(iFrame);

        var title = driver.findElement(NESTED_FRAMES_PARENT_TITLE);
        var actualTitle = title.getText();
        assertEquals(NESTED_FRAMES_PARENT_TITLE_EXPECTED, actualTitle);
    }

    @Test
    void testDragAndDrop() {
        WebElement interactionsElement = driver.findElement(INTERACTIONS_CARD);
        interactionsElement.click();

        WebElement droppableItem = driver.findElement(DROPPABLE_ITEM);
        droppableItem.click();

        WebElement draggable = driver.findElement(INTERACTIONS_DRAGGABLE_ELEMENT);
        WebElement droppable = driver.findElement(INTERACTIONS_DROPPABLE_ELEMENT);
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        var result = driver.findElement(INTERACTIONS_RESULT_MESSAGE);
        var resultText= result.getText();

        assertEquals(INTERACTIONS_RESULT_MESSAGE_EXPECTED, resultText);
    }
}
