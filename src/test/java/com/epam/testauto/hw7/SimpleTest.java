package com.epam.testauto.hw7;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.hw7.JDISite.indexPage;
import static com.epam.testauto.hw7.JDISite.login;
import static com.epam.testauto.hw7.JDISite.metalsColorsPage;


public class SimpleTest extends SimpleTestsInit {

    @Test(description = "Login on JDI site as User Piter_Chailovskii")
    public void loginTest() {
        indexPage.open();
        indexPage.checkOpened();

        login();
        Assert.assertEquals(indexPage.getUserName(), USER_NAME);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void openMetalsColorsPage() {
//        indexPage.header.menu.select("Metals & Colors");
//        TODO rewrite opening Metals&Colors page using header menu
        metalsColorsPage.open();
        metalsColorsPage.checkOpened();
    }

    @Test(dependsOnMethods = {"openMetalsColorsPage"})
    public void fillForm() {
        metalsColorsPage.chooseRadios();
        metalsColorsPage.chooseColors();
        metalsColorsPage.chooseVegetable();
        metalsColorsPage.chooseMetal();
        metalsColorsPage.chooseElement();
    }

    @Test(dependsOnMethods = {"fillForm"})
    public void submitForm() {
        metalsColorsPage.submitButton.click();
    }

    @Test(dependsOnMethods = {"submitForm"})
    public void checkResultSection() {
        metalsColorsPage.checkResult();
    }
}
