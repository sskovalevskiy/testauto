package com.epam.testauto.hw7;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.hw7.JDISite.*;

// TODO-DONE(ADDED) where is gitignore file ???
// TODO-DONE(ADDED) where is HW scenario's steps in your realization ?

// TODO-DONE(RENAMED) such a strange name of class...
public class JdiFrameworkTest extends JdiFrameworkTestsInit {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        Map<String, JsonData> dataMap = MyJsonReader.readFile();
        Object[][] dataArray = new Object[dataMap.size()][1];
        Object[] values = dataMap.values().toArray();
        for (int i = 0; i < dataMap.size(); i++) {
            dataArray[i][0] = values[i];
        }
        return dataArray;
    }

    // TODO you have to use entity driving testing approach
    @Test
    public void loginTest() {
        indexPage.open();
        // TODO read the WH scenario carefully, you have to open pages via Menu class...
        indexPage.checkOpened();
        //    Login on JDI site as User
        login();
        Assert.assertEquals(indexPage.getUserName(), USER_NAME);
        //    Open Metals & Colors page by Header menu
        metalsColorsPage.open();
        metalsColorsPage.checkOpened();
    }

    // TODO what is the reason why you created two tests with
    // TODO dependsOn, instead of created one certain test ??
//    dependsOn us used to prevent constant opening index page,
//    logging and switching to Metals&Colors page in every data case
    @Test(dependsOnMethods = {"loginTest"}, dataProvider = "dataProvider")
    public void fillForm(JsonData data) { // TODO what is the strange name of Class and parameter...

//    Fill form Metals & Colors by data below:
//    Submit form Metals & Colors
        metalsColorsPage.submit(data); // TODO you should use entity driving and UI objects...

//    Result sections should contains data  below:
        metalsColorsPage.checkResult(data);
    }

    @AfterMethod(alwaysRun = true)
    public void refreshPage() {
        metalsColorsPage.refresh();
    }

}
