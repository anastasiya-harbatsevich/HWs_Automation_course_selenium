package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlideMenuBar extends BasePage {
    private static final By CHECK_BOX_MENU_ITEM = By.id("item-1");
    private static final By RADIO_BUTTON_MENU_ITEM = By.id("item-2");
    private static final By BUTTONS_MENU_ITEM = By.id("item-4");
    private static final By LINKS_MENU_ITEM = By.id("item-5");
    private static final By DYNAMIC_PROPERTIES_MENU_ITEM = By.id("item-8");
    private static final By NESTED_FRAMES_ITEM = By.xpath("//div[@class='accordion']/div[3]//div/ul/li[@id='item-3']");
    private static final By DROPPABLE_ITEM = By.xpath("//div[@class='accordion']/div[5]//div/ul/li[@id='item-3']");

    WebDriver driver;

    public SlideMenuBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCheckBoxMenuItem() {
        WebElement checkBoxMenu = driver.findElement(CHECK_BOX_MENU_ITEM);
        checkBoxMenu.click();
    }

    public void clickOnRadioButtonMenuItem() {
        WebElement radioButtonMenu = driver.findElement(RADIO_BUTTON_MENU_ITEM);
        radioButtonMenu.click();
    }

    public void clickOnLinksMenuItem() {
        WebElement linksMenu = driver.findElement(LINKS_MENU_ITEM);
        linksMenu.click();
    }

    public void clickOnButtonsMenuItem() {
        WebElement buttonsMenu = driver.findElement(BUTTONS_MENU_ITEM);
        buttonsMenu.click();
    }

    public void clickOnDynamicPropertiesMenuItem() {
        WebElement dynamicPropertiesItem = driver.findElement(DYNAMIC_PROPERTIES_MENU_ITEM);
        dynamicPropertiesItem.click();
    }

    public void clickOnNestedFramesItem() {
        WebElement framesItem = driver.findElement(NESTED_FRAMES_ITEM);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", framesItem);
    }

    public void clickOnDroppableItem() {
        WebElement droppableItem = driver.findElement(DROPPABLE_ITEM);
        droppableItem.click();
    }

}
