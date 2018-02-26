package com.epam.testauto.hw3;

import com.epam.testauto.TextBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IndexPage {
    public static final String PAGE_TITLE = "Index Page";
    public static final String HEADER = "EPAM FRAMEWORK WISHES…";

    public static final String MAIN_BLOCK_TEXT = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO " +
            "EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
            "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT" +
            " IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";


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

    public IndexPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open(String siteUrl) {
        driver.navigate().to(siteUrl);
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


    public void checkPageTitle(String pageTitle) {
        assertEquals(pageTitle, getPageTitle());
    }

    public void checkUsername(String userName) {
        assertEquals(userName, getUserName());
    }

    public void checkHeaderText(String headerText) {
        assertEquals(headerText, getHeaderText());
    }

    public void checkMainText(String mainBlockText) {
        assertEquals(mainBlockText, getMainText());
    }

    public void checkNumberOfImages(int numberOfImages) {
        assertEquals(numberOfImages, getNumberOfImageBlocks());
    }

    public void checkNumberOfTextBlocksAndInnerText(int numberOfTextblocks, TextBlock[] textBlocks) {
        assertEquals(numberOfTextblocks, getTextBlocks().size());

        for (int i = 0; i < getTextBlocks().size(); i++) {
            assertEquals(textBlocks[i].text, getTextBlocks().get(i).replaceAll("\n", " "));
        }
    }

}
