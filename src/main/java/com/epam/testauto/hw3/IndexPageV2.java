package com.epam.testauto.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.epam.testauto.Constants.PAGE_URL;

public class IndexPageV2 {

    private final WebDriver driver;

    @FindBy(css = "li.dropdown.uui-profile-menu")
    private WebElement uiProfileMenu;

    @FindBy(id = "Login")
    private WebElement loginField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(css = ".btn-login")
    private WebElement loginButton;

    @FindBy(css = ".profile-photo > span")
    private WebElement user;

    @FindBy(css = "h3.main-title")
    private WebElement headerTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainBlockText;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> imageBlocks;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textBlocks;

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
        return imageBlocks.size();
    }

    public List<String> getTextBlocks(){
        List<String> textsInBlocks = new ArrayList<>();
        textBlocks.forEach(textBlock -> textsInBlocks.add(textBlock.getText()));
        return textsInBlocks;
    }




}
