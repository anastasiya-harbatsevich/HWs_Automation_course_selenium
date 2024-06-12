package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage extends BasePage {
    WebDriver driver;

    public LinksPage (WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLinkOpenedInNewTab() {
        WebElement linkOpenedInNewTab = driver.findElement(By.id("simpleLink"));
        linkOpenedInNewTab.click();
    }

    public String getLinkContent() {
        WebElement linkContent = driver.findElement(By.id("simpleLink"));
        return linkContent.getAttribute("href");
    }
}
