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

//    @FindBy(css = "li.dropdown.uui-profile-menu")
//    private SelenideElement uiProfileMenu;

//    @FindBy(id = "#Login")
//    private SelenideElement loginField;

//    @FindBy(id = "#Password")
//    private SelenideElement passwordField;

//    @FindBy(css = ".btn-login")
//    private SelenideElement loginButton;


//    @FindBy(css = ".profile-photo > span")
//    private SelenideElement user;

//    @FindBy(css = "h3.main-title")
//    private SelenideElement headerTitle;

//    @FindBy(css = "p.main-txt")
//    private SelenideElement mainBlockText;

//    @FindBy(css = "li.dropdown > a.dropdown-toggle")
//    private SelenideElement serviceElementInHeader;

//    @FindBy(css = "li.sub-menu > a")
//    private SelenideElement serviceElementInLeftMenu;

    private SelenideElement uiProfileMenu = $("li.dropdown.uui-profile-menu");
    private SelenideElement loginField = $("#Login");
    private SelenideElement passwordField = $("#Password");
    private SelenideElement loginButton = $(".btn-login");
    private SelenideElement user = $(".profile-photo > span");
    private SelenideElement headerTitle = $("h3.main-title");
    private SelenideElement mainBlockText = $("p.main-txt");
    private SelenideElement serviceElementInHeader = $("li.dropdown > a.dropdown-toggle");
    private SelenideElement serviceElementInLeftMenu = $("li.sub-menu > a");
    private ElementsCollection imageBlocks = $$(".icons-benefit");
    private ElementsCollection textBlocks = $$(".benefit-txt");
    private ElementsCollection serviceBlockInHeader = $$("ul.dropdown-menu > li");
    private ElementsCollection serviceBlockInLeftMenu = $$("ul.sub span ");

    public void performLogInUser(String username, String password) {
        uiProfileMenu.click();
        loginField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
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
