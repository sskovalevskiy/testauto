package com.epam.testauto.hw3;

import com.epam.testauto.TextBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.User.USER_LOGIN;
import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.User.USER_PASS;
import static com.epam.testauto.hw3.IndexPage.HEADER;
import static com.epam.testauto.hw3.IndexPage.MAIN_BLOCK_TEXT;
import static com.epam.testauto.hw3.IndexPage.PAGE_TITLE;

public class SeleniumPageObjectTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeSuite
    public void setProperty() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }


    @Test
    public void indexPageTest() {
        //1. Open test site by URL
        indexPage.open(SITE_URL);

        //2. Assert Browser title
        indexPage.checkPageTitle(PAGE_TITLE);

        //3. Perform login
        indexPage.logInUser(USER_LOGIN, USER_PASS);

        //4. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(USER_NAME);

        //5. Assert Browser title
        indexPage.checkPageTitle(PAGE_TITLE);

        //6. Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkNumberOfImages(4);

        //7. Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkNumberOfTextBlocksAndInnerText(4, TextBlock.values());

        //8. Assert that there are the main header and the text below it on the Home Page
        indexPage.checkHeaderText(HEADER);
        indexPage.checkMainText(MAIN_BLOCK_TEXT);
    }

    //9. Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
