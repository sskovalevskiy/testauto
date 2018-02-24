package com.epam.testauto.hw7;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.hw7.JDISite.*;


public class SimpleTest extends SimpleTestsInit {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        Map<String, JsonData> dataMap = JsonReader.readFile();
        Object[][] dataArray = new Object[dataMap.size()][1];
        Object[] values = dataMap.values().toArray();
        for (int i = 0; i < dataMap.size(); i++) {
            dataArray[i][0] = values[i];
        }
        return dataArray;
    }

    @Test
    public void loginTest() {
        indexPage.open();
        indexPage.checkOpened();
        login();
        Assert.assertEquals(indexPage.getUserName(), USER_NAME);
        metalsColorsPage.open();
        metalsColorsPage.checkOpened();
    }

    @Test(dependsOnMethods = {"loginTest"}, dataProvider = "dataProvider")
    public void fillForm(JsonData data) {
        metalsColorsPage.submit(data);
//        metalsColorsPage.checkResult(data);
    }

    @AfterMethod(alwaysRun = true)
    public void refreshPage() {
        metalsColorsPage.refresh();
    }

}
