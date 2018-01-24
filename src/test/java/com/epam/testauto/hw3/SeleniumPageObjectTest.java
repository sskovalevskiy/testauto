package com.epam.testauto.hw3;

import com.epam.testauto.TextBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.testauto.Constants.*;
import static org.junit.Assert.assertEquals;

public class SeleniumPageObjectTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        indexPage = new IndexPage(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void thirdTest() {
        indexPage.open();
        assertEquals(PAGE_TITLE, indexPage.getPageTitle());

        indexPage.logInUser("epam", "1234");
        assertEquals(USER_NAME, indexPage.getUserName());

        assertEquals(HEADER, indexPage.getHeaderText());

        assertEquals(MAIN_BLOCK_TEXT, indexPage.getMainText());

        assertEquals(4, indexPage.getNumberOfImageBlocks());

        assertEquals(4, indexPage.getTextBlocks().size());

        for (int i = 0; i < indexPage.getTextBlocks().size(); i++) {
            assertEquals(TextBlock.values()[i], indexPage.getTextBlocks().get(i));
        }


    }
}
