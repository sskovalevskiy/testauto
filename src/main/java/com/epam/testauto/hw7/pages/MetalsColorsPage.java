package com.epam.testauto.hw7.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.testauto.hw7.JsonData;
import com.epam.testauto.hw7.enums.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MetalsColorsPage extends AbstractPage {

    @FindBy(css = ".vertical-group label")
    private CheckList<Elements> element;

    @FindBy(css = "#odds-selector p")
    public RadioButtons<ValuesOdd> odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons<ValuesEven> evens;

    @JDropdown(
            root = @FindBy(css = ".metals"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = ".caret")
    )
    public Dropdown<Metals> metals;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".filter-option")
    )
    public Dropdown<Colors> colors;

    @JDropdown(
            root = @FindBy(css = ".salad"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = ".salad button")
    )
    public Dropdown<Vegetables> vegetables;

    @FindBy(id = "calculate-button")
    public Button calculateBtn;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    @FindBy(css = ".panel-body-list.results > li")
    public TextList results;

    public void submit(JsonData data) {
        odds.select(data.getSummary()[0]);
        evens.select(data.getSummary()[1]);
        element.select(data.getElements());
        colors.select(data.getColor());
        vegetables.select(Vegetables.Salad);
        for (String vegetable : data.getVegetables()) {
            vegetables.select(vegetable);
        }
        metals.select(data.getMetal());
        submitButton.click();
    }

    public void checkResult(JsonData data) {
        // TODO-DONE what happens in case if results section consist of more rows that we expected ?
        Assert.assertEquals(results.getLabels().size(),data.getStrings().size(), "Results section contains wrong number of strings");
        // TODO-DONE Assert should provide us with readable error message
        Assert.assertTrue(results.getLabels().containsAll(data.getStrings()), "Results section does not contain all data.");
    }
}
