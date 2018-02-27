package com.epam.testauto.hw7;

import com.epam.testauto.hw7.enums.Pages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.hw7.JDISite.indexPage;
import static com.epam.testauto.hw7.JDISite.login;
import static com.epam.testauto.hw7.JDISite.metalsColorsPage;

// TODO-DONE(ADDED) where is gitignore file ???
// TODO-DONE(ADDED) where is HW scenario's steps in your realization ?
// TODO-DONE(RENAMED) such a strange name of class...
public class JdiFrameworkTest extends JdiFrameworkTestsInit {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        Map<String, MetalsColorsFormData> dataMap = MyJsonReader.readFile();
        Object[][] dataArray = new Object[dataMap.size()][1];
        Object[] values = dataMap.values().toArray();
        for (int i = 0; i < dataMap.size(); i++) {
            dataArray[i][0] = values[i];
        }
        return dataArray;
    }

    // TODO-DONE(DELETED) what is the reason why you created two tests with
    // TODO-DONE(DELETED) dependsOn, instead of created one certain test ??
    @Test(dataProvider = "dataProvider")
    public void fillForm(MetalsColorsFormData data) { // TODO-DONE(RENAMED) what is the strange name of Class and parameter...

        indexPage.open();
        indexPage.checkOpened();
        // TODO-DONE you have to use entity driving testing approach
        //    Login on JDI site as User
        login(User.PITER_CHAILOVSKII);
        Assert.assertEquals(indexPage.getUserName(), USER_NAME);
        // TODO read the WH scenario carefully, you have to open pages via Menu class...
        //    Open Metals & Colors page by Header menu
        metalsColorsPage.header.menu.selectItem(Pages.METALS_COLORS);
        metalsColorsPage.checkOpened();

//    Fill form Metals & Colors by data below:
//    Submit form Metals & Colors
        metalsColorsPage.submit(data); // TODO you should use entity driving and UI objects...

//    Result sections should contains data  below:
        metalsColorsPage.checkResult(data);
    }

    @AfterMethod(alwaysRun = true)
    public void refreshPage() {
        metalsColorsPage.header.loginForm.logout();
    }

}
