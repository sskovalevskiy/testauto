package com.epam.testauto.hw3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.epam.testauto.Constants.PAGE_URL;

public class IndexPageV2 {
    private final WebDriver driver;

    private final By IMAGE_BLOCKS = By.cssSelector(".icons-benefit");
    private final By TEXT_BLOCKS = By.cssSelector(".benefit-txt");

    @FindBy(css = "li.dropdown.uui-profile-menu")
    private SelenideElement uiProfileMenu;

    @FindBy(id = "#Login")
    private SelenideElement loginField;

    @FindBy(id = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = ".btn-login")
    private SelenideElement loginButton;

    @FindBy(css = ".profile-photo > span")
    private SelenideElement user;

    @FindBy(css = "h3.main-title")
    private SelenideElement headerTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainBlockText;

    public IndexPageV2(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        driver.navigate().to(PAGE_URL);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void logInUser(String username, String password) {
        uiProfileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getInnerText(WebElement locator){
        return locator.getText();
    }

    public String getUserName(){
        return getInnerText(user);
    }

    public String getHeaderText(){
        return getInnerText(headerTitle);
    }

    public String getMainText(){
        return getInnerText(mainBlockText);
    }

    public long getNumberOfImageBlocks(){
        return driver.findElements(IMAGE_BLOCKS).size();
    }

    public List<String> getTextBlocks(){
        List<WebElement> textBlocksElements = driver.findElements(TEXT_BLOCKS);
        List<String> textBlocks = new ArrayList<>();
        for (WebElement textBlock : textBlocksElements) {
            textBlocks.add(textBlock.getText());
        }
        return textBlocks;
    }




}
