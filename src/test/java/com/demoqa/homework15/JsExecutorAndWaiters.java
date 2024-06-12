package com.demoqa.homework15;

import com.demoqa.Pages.HomePage;
import com.demoqa.Pages.LinksPage;
import com.demoqa.Pages.SlideMenuBar;
import com.demoqa.homework17.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class JsExecutorAndWaiters extends BaseTest {
    HomePage homePage;
    SlideMenuBar slideMenuBar;
    @BeforeEach
    void precondition() {
        homePage = new HomePage(driver);
        slideMenuBar = new SlideMenuBar(driver);
    }
    @Test
    void testLinkOpenedInNewTab() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnLinksMenuItem();

        LinksPage linksPage = new LinksPage(driver);
        linksPage.clickOnLinkOpenedInNewTab();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(tabs.get(1));
        driver.get("https://demoqa.com/");
    }

    @Test
    void testScrollToBookStore() {
        homePage.clickElementsCard();

        homePage.clickOnBookStoreApplicationCard();
    }

    @Test
    void testButtonVisibility() {
        homePage.clickElementsCard();

        slideMenuBar.clickOnDynamicPropertiesMenuItem();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(textToBe(By.id("visibleAfter"), "Visible After 5 Seconds"));
    }
}
