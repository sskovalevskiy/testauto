package com.epam.testauto.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.testauto.TextBlock;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.epam.testauto.Constants.*;
import static com.epam.testauto.User.USER_NAME;

public class IndexPage extends Page {

//    public IndexPage() {
////        PageFactory.initElements(WebDriverRunner.getWebDriver(), IndexPage.class);
//    }

    @FindBy(css = "li.dropdown.uui-profile-menu")
    private SelenideElement uiProfileMenu;
//    private SelenideElement uiProfileMenu = $("li.dropdown.uui-profile-menu");

    @FindBy(id = "#Login")
    private SelenideElement loginField;
//    private SelenideElement loginField = $("#Login");

    @FindBy(id = "#Password")
    private SelenideElement passwordField;
//    private SelenideElement passwordField = $("#Password");

    @FindBy(css = ".btn-login")
    private SelenideElement loginButton;
//    private SelenideElement loginButton = $(".btn-login");


    @FindBy(css = ".profile-photo > span")
    private SelenideElement user;
//    private SelenideElement user = $(".profile-photo > span");

    @FindBy(css = "h3.main-title")
    private SelenideElement headerTitle;
//    private SelenideElement headerTitle = $("h3.main-title");

    @FindBy(css = "p.main-txt")
    private SelenideElement mainBlockText;
//    private SelenideElement mainBlockText = $("p.main-txt");

    @FindBy(css = "li.dropdown > a.dropdown-toggle")
    private SelenideElement serviceElementInHeader;
//    private SelenideElement serviceElementInHeader = $("li.dropdown > a.dropdown-toggle");

    @FindBy(css = "li.sub-menu > a")
    private SelenideElement serviceElementInLeftMenu;
//    private SelenideElement serviceElementInLeftMenu = $("li.sub-menu > a");

    private ElementsCollection imageBlocks = $$(".icons-benefit");
    private ElementsCollection textBlocks = $$(".benefit-txt");
    private ElementsCollection serviceBlockInHeader = $$("ul.dropdown-menu > li");
    private ElementsCollection serviceBlockInLeftMenu = $$("ul.sub span ");

    public IndexPage performLogInUser(String username, String password) {
        uiProfileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public void checkUserName() {
        user.shouldHave(text(USER_NAME));
    }

    public void checkHeader() {
        headerTitle.shouldHave(text(HEADER));
    }

    public void checkMainText() {
        mainBlockText.shouldHave(text(MAIN_BLOCK_TEXT));
    }

    public void checkPicktures() {
        imageBlocks.shouldHaveSize(4);
        for (SelenideElement imageBlock : imageBlocks) {
            imageBlock.shouldBe(visible);
        }
    }

    public void checkTextBlocks() {
        textBlocks.shouldHaveSize(4);
        for (int i = 0; i < textBlocks.size(); i++) {
            textBlocks.get(i).shouldBe(text(TextBlock.values()[i].text));
        }
    }

    public void checkServiceSubcategoryInHeader() {
        checkServiceSubcategory(serviceElementInHeader, serviceBlockInHeader);
    }

    public void checkServiceSubcategoryInLeftMenu() {
        checkServiceSubcategory(serviceElementInLeftMenu, serviceBlockInLeftMenu);
    }

    private void checkServiceSubcategory(SelenideElement serviceButton, ElementsCollection serviceBlock) {
        serviceButton.click();
        serviceBlock.shouldHave(texts(SERVICE_BLOCK_ELEMENTS));
        serviceButton.click();
    }

    public void openPageByUsingHeaderMenu(String pageName) {
        serviceElementInHeader.click();
        serviceBlockInHeader.findBy(text(pageName)).click();
    }


}
