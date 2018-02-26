package com.epam.testauto.hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SelenideWebDriverSettings {

    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

}
