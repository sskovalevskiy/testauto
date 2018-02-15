package com.epam.testauto.hw7;

import org.testng.annotations.Test;

import static com.epam.testauto.hw7.JDISite.indexPage;
import static com.epam.testauto.hw7.JDISite.login;


public class SimpleTest extends SimpleTestsInit {

    @Test
    public void loginTest() {

        indexPage.open();
        indexPage.checkOpened();

        login();

        indexPage.checkUserName();
    }

    @Test
    public void openMetalsColorsPage(){
        indexPage.header.menu.select("Metals & Colors");
    }
}
