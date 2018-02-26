package com.epam.testauto.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatesPage{

    @FindBy(css = "a.ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = "a.ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    @FindBy(css = "div[jdi-type='IRange']")
    private SelenideElement rangeLine;

    public void checkSlidersFunctionality(int leftTargetPosition, int rightTargetPosition) {

        performMovingSliders(leftTargetPosition, rightTargetPosition);

        leftSlider.shouldHave(text(String.valueOf(leftTargetPosition)));
        rightSlider.shouldHave(text(String.valueOf(rightTargetPosition)));
    }

    private void performMovingSliders(int leftTargetPosition, int rightTargetPosition) {
        rangeLine.scrollTo();
        float step = rangeLine.getSize().width / 100f;

        int leftCurrentPosition = Integer.valueOf(leftSlider.getText());
        int rightCurrentPosition = Integer.valueOf(rightSlider.getText());

        int xOffsetLeft = Math.round((leftTargetPosition - leftCurrentPosition - 1) * step);
        int xOffsetRight = Math.round((rightTargetPosition - rightCurrentPosition - 1) * step);

        if (leftTargetPosition < rightCurrentPosition) {
            actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();
            actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();
        } else {
            actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();
            actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();
        }
    }
}
