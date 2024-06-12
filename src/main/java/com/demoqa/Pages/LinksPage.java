package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage extends BasePage {
    private static final By LINK_OPENED_IN_NEW_TAB = By.id("simpleLink");
    private static final By LINK_CONTENT = By.id("simpleLink");

    WebDriver driver;

    public LinksPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLinkOpenedInNewTab() {
        WebElement linkOpenedInNewTab = driver.findElement(LINK_OPENED_IN_NEW_TAB);
        linkOpenedInNewTab.click();
    }

    public String getLinkContent() {
        WebElement linkContent = driver.findElement(LINK_CONTENT);
        return linkContent.getAttribute("href");
    }
}
