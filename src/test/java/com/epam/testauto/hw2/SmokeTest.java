package com.epam.testauto.hw2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.testauto.Constants.PAGE_TITLE;
import static com.epam.testauto.TextBlock.*;
import static org.junit.Assert.assertEquals;

public class SmokeTest extends TestSettings {

    @Test(groups = {"smoke"})
    public void pageTitleTest() {
//        1. Assert Browser title	"Index page"
        assertEquals(PAGE_TITLE, driver.getTitle());
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

//    1. Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
//    2. The test must be developed with help of the DataProvider.
//    3. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
    @Test(dataProvider = "dataProvider", groups = {"smoke"})
    public void firstTest(int index, String text) {
        assertEquals(text, driver.findElements(textBlocks).get(index).getText().replaceAll("\n", " "));
    }

}
