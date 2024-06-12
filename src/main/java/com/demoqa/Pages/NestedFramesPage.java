package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {
    private static final By NESTED_FRAME_PARENT_IFRAME = By.id("frame1");
    private static final By NESTED_FRAMES_PARENT_TITLE = By.xpath("//html/body[text()='Parent frame']");
    WebDriver driver;

    public NestedFramesPage (WebDriver driver) {
        this.driver = driver;
    }

    public void swithToIFrame() {
        var iFrame = driver.findElement(NESTED_FRAME_PARENT_IFRAME);
        driver.switchTo().frame(iFrame);
    }

    public String getNestedFramesParentTitle() {
        var title = driver.findElement(NESTED_FRAMES_PARENT_TITLE);
        return title.getText();
    }
}
