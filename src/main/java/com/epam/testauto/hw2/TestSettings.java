package com.epam.testauto.hw2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.epam.testauto.Constants.PAGE_URL;
import static com.epam.testauto.Constants.WEB_DRIVER;
import static com.epam.testauto.Constants.WEB_DRIVER_PATH;

public class TestSettings {

    public WebDriver driver;

//    1. Use your first ‘SeleniumTest’ and refactor it in a such way, that the test uses all annotations and
//       instructions listed below. Each annotation can contain the only 1 instruction.
//    2. Create a dedicated TestNG config for particular test.
    @BeforeSuite
    public void setUpSystemProperties() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
    }


    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        Maximize Chrome browser window via options
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

//        setting standard timeout within which web driver will wait page-elements
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//        1. Open test site by URL	https://jdi-framework.github.io/tests
        driver.get(PAGE_URL);
    }

    @BeforeMethod
    public void printPageTitle(){
        System.out.println(driver.getTitle());

    }

    @AfterMethod
    public void printTime(){
        System.out.println(System.currentTimeMillis());
    }

    @AfterTest
    public void close(){
        driver.close();
    }
    @AfterSuite
    public void tearDown() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }
}
