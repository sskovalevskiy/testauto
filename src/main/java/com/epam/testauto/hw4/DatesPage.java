package com.epam.testauto.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatesPage extends Page {

    private SelenideElement leftSlider = $("a.ui-slider-handle:nth-of-type(1)");
    private SelenideElement rightSlider = $("a.ui-slider-handle:nth-of-type(2)");

    public void setSliderPositions(int left, int right) {
//        actions().dragAndDropBy(leftSlider, 20, 0).perform();

        int width = $("div[jdi-type='IRange']").getSize().width;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.clickAndHold(leftSlider).moveByOffset(-100, 0).release().build().perform();

//        new Actions(WebDriverRunner.getWebDriver()).clickAndHold().dragAndDropBy(leftSlider, 20, 0).perform();

        Point coordLeft = leftSlider.getCoordinates().inViewPort();
        Point coordRight = rightSlider.getCoordinates().inViewPort();

        Point coordLeft1 = leftSlider.getLocation();
        Point coordRight1 = rightSlider.getLocation();

        Point coorL1 = leftSlider.getCoordinates().onPage();
        Point coorR1 = rightSlider.getCoordinates().onPage();

//        Point res = leftSlider.contextClick().getLocation().moveBy(-30, 0);
//        leftSlider.click(-30, 0);


        String s = "";
    }
}
