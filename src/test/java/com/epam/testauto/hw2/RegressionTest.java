package com.epam.testauto.hw2;

import com.epam.testauto.hw3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.TextBlock.*;
import static com.epam.testauto.User.*;
import static com.epam.testauto.hw3.IndexPage.PAGE_TITLE;
import static org.junit.Assert.assertEquals;

public class RegressionTest{

    private WebDriver driver;
    private IndexPage indexPage;

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {0, FIRST_BLOCK.text},
                {1, SECOND_BLOCK.text},
                {2, THIRD_BLOCK.text},
                {3, FORTH_BLOCK.text}
        };
    }

    @BeforeSuite
    public void setUpSystemProperties() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        // Open test site by URL	https://jdi-framework.github.io/tests
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        driver.get(SITE_URL);
    }

    //1. Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
    //2. The test must be developed with help of the DataProvider.
    //3. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
    @Test(dataProvider = "dataProvider", groups = {"regression"})
    public void textsInBlocksTest(int index, String text) {
        assertEquals(text, indexPage.getTextBlocks().get(index).replaceAll("\n", " "));
    }

    @Test(groups = {"regression"})
    public void pageTitleTest() {
        //2. Assert Browser title	"Index page"
        assertEquals(driver.getTitle(), PAGE_TITLE);
    }

    @Test(groups = {"regression"})
    public void loginTest() {
        //3. Perform login	username: epam, pass: 1234
        indexPage.logInUser(USER_LOGIN,USER_PASS);

        //4. Assert User name in the left-top side of screen that user is loggined	"Piter Chailovskii"
        assertEquals(USER_NAME, indexPage.getUserName());
    }

    @AfterTest
    public void close(){
        driver.close();
    }

    @AfterSuite
    public void tearDown() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }
}
