package com.epam.testauto.hw2;

import com.epam.testauto.hw3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.TextBlock.*;
import static org.junit.Assert.assertEquals;

public class SeleniumTest{

    private WebDriver driver;
    private IndexPage indexPage;

    @DataProvider(name = "dataProvider", parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {0, FIRST_BLOCK.text},
                {1, SECOND_BLOCK.text},
                {2, THIRD_BLOCK.text},
                {3, FORTH_BLOCK.text}
        };
    }

    //1. Use your first ‘SeleniumTest’ and refactor it in a such way, that the test uses all annotations and
    //   instructions listed below. Each annotation can contain the only 1 instruction.
    //2. Create a dedicated TestNG config for particular test.
    @BeforeSuite
    public void setUpSystemProperties() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        // Open test site by URL	https://jdi-framework.github.io/tests
        driver.get(SITE_URL);
    }

    @BeforeMethod
    public void printPageTitle(){
        System.out.println(System.currentTimeMillis());
    }

    //1. Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
    //2. The test must be developed with help of the DataProvider.
    //3. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
    @Test(dataProvider = "dataProvider")
    public void checkTextsBelowPictures(int index, String text) {
        assertEquals(text, indexPage.getTextBlocks().get(index).replaceAll("\n", " "));
    }

    @AfterMethod
    public void printTime(){
        System.out.println(driver.getTitle());
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
