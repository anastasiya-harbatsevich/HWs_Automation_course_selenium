package com.demoqa.homework14;

import com.demoqa.Pages.*;
import com.demoqa.homework17.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SeleniumWebDriver extends BaseTest {
    private static final String BUTTONS_RESULT_MESSAGE = "You have selected";
    private static final String LINK_HREF_CONTENT = "https://demoqa.com/";
    private static final String RIGHT_CLICK_RESULT_MESSAGE = "You have done a right click";
    private static final String DOUBLE_CLICK_RESULT_MESSAGE = "You have done a double click";

    HomePage homePage;
    SlideMenuBar slideMenuBar;
    CheckBoxPage_PageFactory checkBoxPage_pageFactory;

    @BeforeEach
    void precondition() {
        homePage = new HomePage(driver);
        slideMenuBar = new SlideMenuBar(driver);
        checkBoxPage_pageFactory = new CheckBoxPage_PageFactory(driver);
    }

    @Test
    void testImpressiveRadioButton() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnRadioButtonMenuItem();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage(driver);
        radioButtonsPage.clickOnImpressiveRadioButton();

        String radioButtonTitle = radioButtonsPage.getRadioButtonTitle();
        String radioButtonResultMessage = radioButtonsPage.getCommonResultMessage();


        String expectedTextMessage = String.join(" ", BUTTONS_RESULT_MESSAGE, radioButtonTitle);
        assertEquals(expectedTextMessage, radioButtonResultMessage);
    }

    @Test
    void testCheckBoxSelection() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnCheckBoxMenuItem();

        checkBoxPage_pageFactory.clickOnFirstLevelDropDownList();
        checkBoxPage_pageFactory.clickOnSecondLevelDropDownList();
        checkBoxPage_pageFactory.clickOnExcelFileItem();

        String actualMessage = checkBoxPage_pageFactory.getActualMessageText();

        String expectedMessage = String.join(" ", BUTTONS_RESULT_MESSAGE, ":\nexcelFile");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLinkContent() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnLinksMenuItem();
        LinksPage linksPage = new LinksPage(driver);
        String link = linksPage.getLinkContent();

        assertEquals(LINK_HREF_CONTENT, link);
    }

    @Test
    void testRightClick() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnButtonsMenuItem();

        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickRightClickButton();

        String resultMessage = buttonsPage.getRightClickResultMessage();

        assertEquals(RIGHT_CLICK_RESULT_MESSAGE, resultMessage);
    }

    @Test
    void testDoubleClick() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnButtonsMenuItem();

        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickDoubleClick();

        String resultMessage = buttonsPage.getDoubleClickResultMessage();

        assertEquals(DOUBLE_CLICK_RESULT_MESSAGE, resultMessage);
    }
}
