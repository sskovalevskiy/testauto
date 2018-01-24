package com.epam.testauto.hw4;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.testauto.Constants.*;
import static org.junit.Assert.assertEquals;

public class SelenideBasedTest extends SelenideWebDriverSettings {

    private IndexPage indexPage = new IndexPage();
    private DifferentElementsPage differentElementsPage;

    @Test
    public void forthTest() {
//        1. Open test site by URL
        open(PAGE_URL);

//        2. Perform login	username: epam, pass: 1234
        indexPage.performLogInUser("epam", "1234");

//        3. Assert User name in the left-top side of screen that user is loggined	"PITER CHAILOVSKII"
        indexPage.checkUserName();

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
        differentElementsPage = (DifferentElementsPage) indexPage.openPageByUsingHeaderMenu("Different Elements");

//        8. Check interface on Service page, it contains all needed elements.
//     	  4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.	Elements exists
        differentElementsPage.checkElementsOnPage();

//        9. Select and assert checkboxes	Water, Wind	Elements are checked
        differentElementsPage.selectAndAssertCheckboxes("Water", "Wind");

//        10. Select radio	Selen	Element is checked
//        11. Select in dropdown	Yellow	Element is selected
//        12. Check in logs section selected values and status (true|false)	Water, Wind, Selen, Yellow	Rows exists
//        13. Unselect and assert checkboxes	Water, Wind	Elements are unchecked
//        14. Check in logs section unselected values and status (true|false)	Water, Wind	Rows exists


    }


}
