package com.epam.testauto.hw4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatesPage extends Page {

    private SelenideElement leftSlider = $("a.ui-slider-handle:nth-of-type(1)");
    private SelenideElement rightSlider = $("a.ui-slider-handle:nth-of-type(2)");
    private SelenideElement rangeLine = $("div[jdi-type='IRange']");

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

        if (xOffsetLeft < xOffsetRight) {
            actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();
            actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();
        } else {
            actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();
            actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();
        }
    }
}
