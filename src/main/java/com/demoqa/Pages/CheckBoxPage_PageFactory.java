package com.demoqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage_PageFactory extends BasePage {
    @FindBy(xpath = "//ol/li[1]//button[@aria-label='Toggle']")
    private WebElement firstLevelDropDownList;

    @FindBy(xpath = "//ol/li[3]//button[@aria-label='Toggle']")
    private WebElement secondLevelDropDownList;

    @FindBy(xpath = "//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']")
    private WebElement excelFileItem;

    @FindBy(id = "result")
    private WebElement message;

    WebDriver driver;

    public CheckBoxPage_PageFactory (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstLevelDropDownList() {
        firstLevelDropDownList.click();
    }

    public void clickOnSecondLevelDropDownList() {
        secondLevelDropDownList.click();
    }

    public void clickOnExcelFileItem() {
        excelFileItem.click();
    }

    public String getActualMessageText() {
       return message.getText();
    }
}
