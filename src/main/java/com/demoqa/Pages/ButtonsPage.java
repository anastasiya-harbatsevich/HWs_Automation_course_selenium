package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {
    private static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");
    private static final By RIGHT_CLICK_MESSAGE = By.id("rightClickMessage");
    private static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    private static final By DOUBLE_CLICK_MESSAGE = By.id("doubleClickMessage");

    WebDriver driver;

    public ButtonsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickRightClickButton() {
        WebElement rightClickButton = driver.findElement(RIGHT_CLICK_BTN);
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).perform();
    }

    public String getRightClickResultMessage() {
        WebElement rightClickResultMessage = driver.findElement(RIGHT_CLICK_MESSAGE);
        return rightClickResultMessage.getText();
    }

    public void clickDoubleClick() {
        WebElement doubleClickButton = driver.findElement(DOUBLE_CLICK_BTN);
        Actions action = new Actions(driver);
        action.contextClick(doubleClickButton).doubleClick().build().perform();
    }

    public String getDoubleClickResultMessage() {
        WebElement doubleClickResultMessage = driver.findElement(DOUBLE_CLICK_MESSAGE);
        return doubleClickResultMessage.getText();
    }
}
