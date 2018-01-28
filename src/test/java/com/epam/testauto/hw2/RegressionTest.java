package com.epam.testauto.hw2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.TextBlock.*;
import static com.epam.testauto.User.*;
import static org.junit.Assert.assertEquals;

public class RegressionTest extends TestSettings {

    @DataProvider(name = "dataProvider")
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
    @Test(dataProvider = "dataProvider")
    public void textsInBlocksTest(int index, String text) {
        assertEquals(text, driver.findElements(textBlocks).get(index).getText().replaceAll("\n", " "));
    }

    @Test
    public void pageTitleTest() {
//        2. Assert Browser title	"Index page"
        assertEquals(driver.getTitle(), PAGE_TITLE);
    }

    @Test
    public void loginTest() {

//        3. Perform login	username: epam, pass: 1234
        driver.findElement(uiProfileMenu).click();
        driver.findElement(login).sendKeys(USER_LOGIN);
        driver.findElement(password).sendKeys(USER_PASS);
        driver.findElement(loginBtn).click();

//        4. Assert User name in the left-top side of screen that user is loggined	"Piter Chailovskii"
        assertEquals(USER_NAME, driver.findElement(user).getText());

    }
}
