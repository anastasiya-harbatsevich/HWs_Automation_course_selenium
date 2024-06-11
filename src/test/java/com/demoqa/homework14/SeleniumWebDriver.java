package com.demoqa.homework14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SeleniumWebDriver {
    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private static final By RADIO_BUTTON_MENU_ITEM = By.id("item-2");
    private static final By RADIO_BUTTON_COMMON_MESSAGE_RESULT = By.xpath("//p[@class='mt-3']");
    private static final By IMPRESSIVE_RADIO_BUTTON_NAME = By.xpath("//label[@class='custom-control-label']");
    private static final String RADIO_BUTTON_RESULT_MESSAGE = "You have selected";
    private static final String LINK_HREF_CONTENT = "https://demoqa.com/";
    private static final String RIGHT_CLICK_RESULT_MESSAGE = "You have done a right click";
    private static final String DOUBLE_CLICK_RESULT_MESSAGE = "You have done a double click";
    private static final By CHECK_BOX_MENU_ITEM = By.id("item-1");
    private static final By FIRST_LEVEL_DROP_DOWN_LIST = By.xpath("//ol/li[1]//button[@aria-label='Toggle']");
    private static final By SECOND_LEVEL_DROP_DOWN_LIST = By.xpath("//ol/li[3]//button[@aria-label='Toggle']");
    private static final By EXCEL_FILE_ITEM = By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']");
    private static final By BUTTONS_MENU_ITEM = By.id("item-4");
    private static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");
    private static final By RIGHT_CLICK_MESSAGE = By.id("rightClickMessage");
    private static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    private static final By DOUBLE_CLICK_MESSAGE = By.id("doubleClickMessage");

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    void cleanUp(){
        driver.quit();
    }
    @Test
    void testImpressiveRadioButton() {

        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement radioButtonMenu = driver.findElement(RADIO_BUTTON_MENU_ITEM);
        radioButtonMenu.click();

        WebElement radioButtonName = driver.findElement(IMPRESSIVE_RADIO_BUTTON_NAME);
        String radioButtonTitle = radioButtonName.getText();
        radioButtonName.click();

        WebElement message = driver.findElement(RADIO_BUTTON_COMMON_MESSAGE_RESULT);
        String actualMessage = message.getText();

        String expectedTextMessage = String.join(" ", RADIO_BUTTON_RESULT_MESSAGE, radioButtonTitle);
        assertEquals(expectedTextMessage, actualMessage);
    }

    @Test
    void testCheckBoxSelection() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement checkBoxMenu = driver.findElement(CHECK_BOX_MENU_ITEM);
        checkBoxMenu.click();

        WebElement firstLevelDropDownList = driver.findElement(FIRST_LEVEL_DROP_DOWN_LIST);
        firstLevelDropDownList.click();

        WebElement secondLevelDropDownList = driver.findElement(SECOND_LEVEL_DROP_DOWN_LIST);
        secondLevelDropDownList.click();

        WebElement excelFileItem = driver.findElement(EXCEL_FILE_ITEM);
        excelFileItem.click();

        WebElement message = driver.findElement(By.id("result"));
        String actualMessage = message.getText();

        String expectedMessage = String.join(" ", RADIO_BUTTON_RESULT_MESSAGE, ":\nexcelFile");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLinkContent() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement linksMenu = driver.findElement(By.id("item-5"));
        linksMenu.click();

        WebElement linkContent = driver.findElement(By.id("simpleLink"));
        String link = linkContent.getAttribute("href");

        assertEquals(LINK_HREF_CONTENT, link);
    }

    @Test
    void testRightClick() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement buttonsMenu = driver.findElement(BUTTONS_MENU_ITEM);
        buttonsMenu.click();

        WebElement rightClickButton = driver.findElement(RIGHT_CLICK_BTN);
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).perform();

        WebElement rightClickResultMessage = driver.findElement(RIGHT_CLICK_MESSAGE);
        String resultMessage = rightClickResultMessage.getText();

        assertEquals(RIGHT_CLICK_RESULT_MESSAGE, resultMessage);
    }

    @Test
    void testDoubleClick() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement buttonsMenu = driver.findElement(BUTTONS_MENU_ITEM);
        buttonsMenu.click();

        WebElement doubleClickButton = driver.findElement(DOUBLE_CLICK_BTN);
        Actions action = new Actions(driver);
        action.contextClick(doubleClickButton).doubleClick().build().perform();

        WebElement doubleClickResultMessage = driver.findElement(DOUBLE_CLICK_MESSAGE);
        String resultMessage = doubleClickResultMessage.getText();

        assertEquals(DOUBLE_CLICK_RESULT_MESSAGE, resultMessage);
    }
}
