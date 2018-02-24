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
            value = @FindBy(css = "span.caret")
    )
    public Dropdown<Metals> metals;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".text")
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

//        metals.select(Metals.Selen);
//        metals.select(data.getMetal());
//        colors.select(data.getColor());
//        vegetables.select(data.getVegetables());
    }

    public void checkResult(JsonData data) {
        Assert.assertTrue(results.getLabels().containsAll(data.getStrings()));
    }
}
