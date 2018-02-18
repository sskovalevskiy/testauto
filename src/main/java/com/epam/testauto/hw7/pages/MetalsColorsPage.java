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
    private CheckList element;

    @FindBy(css = "#odds-selector p")
    public RadioButtons<ValuesOdd> odds;
    @FindBy(css = "#even-selector p")
    public RadioButtons<ValuesEven> evens;


    @JDropdown(
            root = @FindBy(css = ".metals"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "span.caret")
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

    public void chooseColor(Colors color) {
        colors.select(color);
    }

    public void chooseVegetables(Vegetables... vegetablesToSelect) {
        for (Vegetables vegetable : vegetablesToSelect) {
            vegetables.select(vegetable);
        }
    }

    public void chooseMetal(Metals metal) {
        metals.select(metal);
    }

    public void chooseElements(Elements... elements) {
        element.select(elements);
    }

    public void chooseRadioNumbers(String[] numbers) {
        odds.select(numbers[0]);
        evens.select(numbers[1]);
        calculateBtn.click();
    }

    public void checkResult(JsonData data) {
        Assert.assertTrue(results.getLabels().containsAll(data.getStrings()));
    }
}
