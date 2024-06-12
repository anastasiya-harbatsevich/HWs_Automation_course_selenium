package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsPage extends BasePage {
    private static final By IMPRESSIVE_RADIO_BUTTON_NAME = By.xpath("//label[@class='custom-control-label']");
    private static final By RADIO_BUTTON_COMMON_MESSAGE_RESULT = By.xpath("//p[@class='mt-3']");

    WebDriver driver;

    public RadioButtonsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnImpressiveRadioButton() {
        WebElement impressiveRadioButton = driver.findElement(IMPRESSIVE_RADIO_BUTTON_NAME);
        impressiveRadioButton.click();
    }

    public String getRadioButtonTitle() {
        WebElement radioButtonTitle = driver.findElement(IMPRESSIVE_RADIO_BUTTON_NAME);
        return radioButtonTitle.getText();
    }

    public String getCommonResultMessage() {
        WebElement actualMessage = driver.findElement(RADIO_BUTTON_COMMON_MESSAGE_RESULT);
        return actualMessage.getText();
    }
}
