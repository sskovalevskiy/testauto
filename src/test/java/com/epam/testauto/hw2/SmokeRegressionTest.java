package com.epam.testauto.hw2;

import com.epam.testauto.TextBlock;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.TextBlock.*;
import static org.junit.Assert.assertEquals;

public class SmokeRegressionTest extends TestSettings {

    @DataProvider(name = "dataProvider", parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {0, FIRST_BLOCK.text},
                {1, SECOND_BLOCK.text},
                {2, THIRD_BLOCK.text},
                {3, FORTH_BLOCK.text}
        };
    }

    //    1. Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
//    2. The test must be developed with help of the DataProvider.
//    3. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
    @Test(dataProvider = "dataProvider", groups = {"smoke", "regression"})
    public void firstTest(int index, String text) {
        assertEquals(text, driver.findElements(textBlocks).get(index).getText().replaceAll("\n", " "));
    }

    @Test(groups = {"smoke", "regression"})
    public void secondTest() {

//        2. Assert Browser title	"Index page"
        assertEquals(PAGE_TITLE, driver.getTitle());
    }

    @Test(groups = {"smoke", "regression"})
    public void forthTest() {
//        6. Assert that there are 4 images on the Home Page and they are displayed	(4 images)
        assertEquals(4, driver.findElements(imageBlocks).size());

//        7.1 Assert that there are 4 texts on the Home Page
        List<WebElement> textInBlocks = driver.findElements(textBlocks);
        assertEquals(4, textInBlocks.size());

        for (int i = 0; i < textInBlocks.size(); i++) {
            String textInTheBlock = textInBlocks.get(i).getText().replaceAll("\n", " ");
//        7.2   and check them by getting texts 	(4 texts below of each image)
            assertEquals(TextBlock.values()[i].text, textInTheBlock);
        }

//        8. Assert that there are the main header and the text below it on the Home Page
        assertEquals(HEADER, driver.findElement(headerTitle).getText());
        assertEquals(MAIN_BLOCK_TEXT, driver.findElement(mainBlockTxt).getText());
    }
}
