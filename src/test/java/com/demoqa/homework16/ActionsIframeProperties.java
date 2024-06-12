package com.demoqa.homework16;

import com.demoqa.Pages.HomePage;
import com.demoqa.Pages.NestedFramesPage;
import com.demoqa.Pages.SlideMenuBar;
import com.demoqa.homework17.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class ActionsIframeProperties extends BaseTest {
    private static final String NESTED_FRAMES_PARENT_TITLE_EXPECTED = "Parent frame";
    private static final String INTERACTIONS_RESULT_MESSAGE_EXPECTED = "Dropped!";
    private static final By INTERACTIONS_DRAGGABLE_ELEMENT = By.id("draggable");
    private static final By INTERACTIONS_DROPPABLE_ELEMENT = By.id("droppable");
    private static final By INTERACTIONS_RESULT_MESSAGE = By.id("droppable");

    HomePage homePage;
    SlideMenuBar slideMenuBar;
    @BeforeEach
    void precondition() {
        homePage = new HomePage(driver);
        slideMenuBar = new SlideMenuBar(driver);
    }

    @Test
    void testIframe() {
        homePage.clickAlertsFrameWindowCard();

        slideMenuBar.clickOnNestedFramesItem();

        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        nestedFramesPage.swithToIFrame();

        var actualTitle = nestedFramesPage.getNestedFramesParentTitle();
        assertEquals(NESTED_FRAMES_PARENT_TITLE_EXPECTED, actualTitle);
    }

    @Test
    void testDragAndDrop() {
        homePage.clickInteractionsCard();

        slideMenuBar.clickOnDroppableItem();

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
