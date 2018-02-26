package com.epam.testauto.hw2;

import com.epam.testauto.TextBlock;
import com.epam.testauto.hw3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.TextBlock.*;
import static com.epam.testauto.hw3.IndexPage.*;
import static org.junit.Assert.assertEquals;

public class SmokeRegressionTest{

    private WebDriver driver;
    private IndexPage indexPage;

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

    @DataProvider(name = "dataProvider", parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {0, FIRST_BLOCK.text},
                {1, SECOND_BLOCK.text},
                {2, THIRD_BLOCK.text},
                {3, FORTH_BLOCK.text}
        };
    }

    //1. Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
    //2. The test must be developed with help of the DataProvider.
    //3. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
    @Test(dataProvider = "dataProvider", groups = {"smoke", "regression"})
    public void firstTest(int index, String text) {
        assertEquals(text, indexPage.getTextBlocks().get(index).replaceAll("\n", " "));
    }

    @Test(groups = {"smoke", "regression"})
    public void secondTest() {

        //2. Assert Browser title	"Index page"
        assertEquals(PAGE_TITLE, driver.getTitle());
    }

    @Test(groups = {"smoke", "regression"})
    public void forthTest() {
        //6. Assert that there are 4 images on the Home Page and they are displayed	(4 images)
        assertEquals(4, indexPage.getNumberOfImageBlocks());

        //7.1 Assert that there are 4 texts on the Home Page and check them by getting texts 	(4 texts below of each image)

        assertEquals(4, indexPage.getTextBlocks().size());

        for (int i = 0; i < indexPage.getTextBlocks().size(); i++) {
            String textInTheBlock = indexPage.getTextBlocks().get(i).replaceAll("\n", " ");
            assertEquals(TextBlock.values()[i].text, textInTheBlock);
        }

        //8. Assert that there are the main header and the text below it on the Home Page
        assertEquals(HEADER, indexPage.getHeaderText());
        assertEquals(MAIN_BLOCK_TEXT, indexPage.getMainText());
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
