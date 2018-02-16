package com.epam.testauto.hw7.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.testauto.hw7.enums.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MetalsColorsPage extends AbstractPage {

    @Css(".vertical-group label")
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

    public void chooseColors() {
        colors.select(Colors.Red);
    }

    public void chooseVegetable() {
        vegetables.select(Vegetables.Cucumber);
        vegetables.select(Vegetables.Tomato);
        vegetables.select(Vegetables.Salad);
    }

    public void chooseMetal() {
        metals.select(Metals.Selen);
    }

    public void chooseElement() {
        element.select(Elements.Water);
        element.select(Elements.Fire);
    }

    public void chooseRadios() {
        odds.select(ValuesOdd.THREE.txt);
        evens.select(ValuesEven.EIGHT.txt);
        calculateBtn.click();
    }

    public void checkResult() {

        results.getLabels().forEach(e ->
                Assert.assertTrue(ResultText.getTextList().contains(e)));
    }
}
