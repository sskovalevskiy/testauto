package com.epam.testauto.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage{

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = "label.label-checkbox > input")
    private ElementsCollection checkboxInputs;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".label-radio > input")
    private ElementsCollection radioButtonInputs;

    @FindBy(css = "div.colors > select")
    private SelenideElement dropdownColors;

    @FindBy(css = "button.uui-button")
    private SelenideElement defaultButton;

    @FindBy(css = "input[type='button'].uui-button")
    private SelenideElement button;

    @FindBy(css = "div._mCS_1")
    private SelenideElement leftSection;

    @FindBy(css = "div._mCS_2")
    private SelenideElement rightSection;
    @FindBy(css = ".info-panel-section > ul.logs > li")
    private ElementsCollection logs;

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
