package com.epam.testauto.hw1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.epam.testauto.Constants.WEB_DRIVER;
import static com.epam.testauto.Constants.WEB_DRIVER_PATH;

public class WebDriverSettings {

    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
//        Maximize Chrome browser window via options
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

//        setting standard timeout within which web driver will wait page-elements
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.quit();
    }
}
