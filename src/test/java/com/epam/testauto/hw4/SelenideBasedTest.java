package com.epam.testauto.hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.testauto.Constants.*;

public class SelenideBasedTest{

    private IndexPage indexPage = new IndexPage();
    private DifferentElementsPage differentElementsPage = new DifferentElementsPage();
    private DatesPage datesPage = new DatesPage();

    @Before
    public void testPreparation(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
//        Configuration.holdBrowserOpen = true;
//        Configuration.headless = true;

//        1. Open test site by URL
        open(PAGE_URL);


//        2. Perform login	username: epam, pass: 1234
        indexPage.performLogInUser("epam", "1234");


//        3. Assert User name in the left-top side of screen that user is loggined	"PITER CHAILOVSKII"
        indexPage.checkUserName();

    }
    @Test
    public void testCase1() {

//        4. Check interface on Home page, it contains all needed elements.	4 - pictures, 4 texts under them, 2 text above
        indexPage.checkHeader();
        indexPage.checkMainText();
        indexPage.checkPicktures();
        indexPage.checkTextBlocks();

//        5. Click on "Service" subcategory in the HEADER and check that drop down contains options
//        "Support, Dates, Complex Table, Simple Table, Tables With Wages, Different Elements"
        indexPage.checkServiceSubcategoryInHeader();

//        6. Click on Service subcategory in the LEFT SECTION and check that drop down contains options
//        "Support, Dates, Complex Table, Simple Table, Tables With Wages, Different Elements"
        indexPage.checkServiceSubcategoryInLeftMenu();

//        7. Open through the header menu Service -> Different Elements Page
        indexPage.openPageByUsingHeaderMenu("Different Elements");

//        8. Check interface on Service page, it contains all needed elements.
//     	  4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.	Elements exists
        differentElementsPage.checkElementsOnPage();

//        9. Select and assert checkboxes	Water, Wind	Elements are checked
        differentElementsPage.selectAndAssertCheckboxes("Water", "Wind");

//        10. Select radio	Selen	Element is checked
        differentElementsPage.selectAndAssertRadioButton("Selen");

//        11. Select in dropdown	Yellow	Element is selected
        differentElementsPage.selectColorInDropdown("Yellow");

//        12. Check in logs section selected values and status (true|false)	Water, Wind, Selen, Yellow	Rows exists
        differentElementsPage.checkLogsInTheRightPanel();

//        13. Unselect and assert checkboxes	Water, Wind	Elements are unchecked
//        14. Check in logs section unselected values and status (true|false)	Water, Wind	Rows exists
        differentElementsPage.uncheckSelectedBoxesAndAssertLogs();
    }

    @Test
    public void testCase2(){

//        4. Open Service -> Dates		Page is opened
        indexPage.openPageByUsingHeaderMenu("Dates");
//        5. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position	left - 0, right - 100	MAX range is set. Check sliders values.

//        datesPage.setSliderPositions(0, 0);
//        6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.	left - 0, right - 0	MIN-left range is set
//        7. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.	 left - 0, right - 0	MIN-right range is set
//        8. Using drag-and-drop set Range sliders.	left - 30, right - 70	Range is set. Check sliders values.


    }

    @After
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }



}
