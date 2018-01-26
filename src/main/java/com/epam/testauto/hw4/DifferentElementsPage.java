package com.epam.testauto.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage extends Page {

    private ElementsCollection checkboxes = $$("label.label-checkbox");
    private ElementsCollection checkboxInputs = $$("label.label-checkbox > input");
    private ElementsCollection radioButtons = $$(".label-radio");
    private ElementsCollection radioButtonInputs = $$(".label-radio > input");
    private SelenideElement dropdownColors = $("div.colors > select");
    private SelenideElement defaultButton = $("button.uui-button");
    private SelenideElement button = $("input[type='button'].uui-button");
    private SelenideElement leftSection = $("div._mCS_1");
    private SelenideElement rightSection = $("div._mCS_2");
    private ElementsCollection logs = $$(".info-panel-section > ul.logs > li");

    public void checkElementsOnPage() {
        checkboxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropdownColors.isDisplayed();
        defaultButton.isDisplayed();
        button.isDisplayed();
        leftSection.isDisplayed();
        rightSection.isDisplayed();
    }

    public void selectAndAssertCheckboxes(String... names) {
        for (String name : names) {
            checkboxes.findBy(text(name)).setSelected(true).isSelected();
        }
    }

    public void selectAndAssertRadioButton(String radio) {
        radioButtons.findBy(text(radio)).setSelected(true).isSelected();
    }

    public void selectColorInDropdown(String color) {
        dropdownColors.selectOption(color);
    }

    public void checkLogsInTheRightPanel() {
        for (String selectedCheckbox : checkboxInputs.filterBy(selected).texts()) {
            logs.findBy(matchesText(selectedCheckbox + ": condition changed to true")).should(exist);
        }

        String selectedRadioButton = radioButtonInputs.findBy(selected).parent().getText();
        logs.findBy(matchesText("metal: value changed to " + selectedRadioButton)).should(exist);

        String selectedColor = dropdownColors.getSelectedOption().getText();
        logs.findBy(matchesText("Colors: value changed to " + selectedColor)).should(exist);
    }

    public void uncheckSelectedBoxesAndAssertLogs() {
        for (SelenideElement selectedCheckbox : checkboxInputs.filterBy(selected)) {
            selectedCheckbox.setSelected(false).is(not(selected));
            logs.findBy(matchesText(selectedCheckbox.parent().getText() + ": condition changed to false")).should(exist);
        }
    }
}
