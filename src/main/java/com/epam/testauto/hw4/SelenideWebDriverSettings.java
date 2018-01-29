package com.epam.testauto.hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;

public class SelenideWebDriverSettings {

    @Rule
    public TestRule report = new TextReport();

    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
//        Configuration.holdBrowserOpen = true;
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

}
