package com.epam.testauto.hw4;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage implements Page {

    private ElementsCollection checkboxes = $$("input[type='checkbox']");
    private ElementsCollection radioButtons = $$("input[type='radio']");
    private SelenideElement dropdownColors = $("div.colors");
    private SelenideElement defaultButton = $("button.uui-button");
    private SelenideElement button = $("input[type='button'].uui-button");
    private SelenideElement leftSection = $("div._mCS_1");
    private SelenideElement rightSection = $("div._mCS_2");

    public void checkElementsOnPage() {
        checkboxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropdownColors.isDisplayed();
        defaultButton.isDisplayed();
        button.isDisplayed();
        leftSection.isDisplayed();
        rightSection.isDisplayed();
    }

    public void selectAndAssertCheckboxes(String... names){
//        for (String name : names) {
//            checkboxes.findBy(text(name)).click();
//        }
    }
}
