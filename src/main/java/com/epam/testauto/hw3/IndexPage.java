package com.epam.testauto.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.testauto.Constants.PAGE_URL;

public class IndexPage {
    private final WebDriver driver;

    private final String username = "epam";
    private final String password = "1234";

    private final By UI_PROFILE_MENU = By.cssSelector("li.dropdown.uui-profile-menu");
    private final By LOGIN_ID = By.id("Login");
    private final By PASSWORD_ID = By.id("Password");
    private final By LOGIN_BTN = By.cssSelector(".btn-login");
    private final By USER = By.cssSelector(".profile-photo > span");
    private final By HEADER_TITLE = By.cssSelector("h3.main-title");
    private final By MAIN_BLOCK_TEXT = By.cssSelector("p.main-txt");
    private final By IMAGE_BLOCKS = By.cssSelector(".icons-benefit");
    private final By TEXT_BLOCKS = By.cssSelector(".benefit-txt");

    public IndexPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        driver.navigate().to(PAGE_URL);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public IndexPage logInUser(String username, String password) {
        driver.findElement(UI_PROFILE_MENU).click();
        driver.findElement(LOGIN_ID).sendKeys(username);
        driver.findElement(PASSWORD_ID).sendKeys(password);
        driver.findElement(LOGIN_BTN).click();
        return this;
    }

    public IndexPage defaultUserLogin(){
        return logInUser(username, password);
    }

    public String getInnerText(By locator){
        return driver.findElement(locator).getText();
    }

    public String getUserName(){
        return getInnerText(USER);
    }

    public String getHeaderText(){
        return getInnerText(HEADER_TITLE);
    }

    public String getMainText(){
        return getInnerText(MAIN_BLOCK_TEXT);
    }

    public long getNumberOfImageBlocks(){
        return driver.findElements(IMAGE_BLOCKS).size();
    }

    public List<String> getTextBlocks(){
        List<WebElement> textBlocksElements = driver.findElements(TEXT_BLOCKS);
        List<String> textBlocks = new ArrayList<String>();
        for (WebElement textBlock : textBlocksElements) {
            textBlocks.add(textBlock.getText());
        }
        return textBlocks;
    }




}
