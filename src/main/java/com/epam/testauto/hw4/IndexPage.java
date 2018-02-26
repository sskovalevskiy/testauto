package com.epam.testauto.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.testauto.TextBlock;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.epam.testauto.Constants.SERVICE_BLOCK_ELEMENTS;
import static com.epam.testauto.hw3.IndexPage.HEADER;
import static com.epam.testauto.hw3.IndexPage.MAIN_BLOCK_TEXT;

public class IndexPage{

    @FindBy(css = "li.dropdown.uui-profile-menu")
    private SelenideElement uiProfileMenu;

    @FindBy(id = "Login")
    private SelenideElement loginField;

    @FindBy(id = "Password")
    private SelenideElement passwordField;

    @FindBy(css = ".btn-login")
    private SelenideElement loginButton;

    @FindBy(css = ".profile-photo > span")
    private SelenideElement user;

    @FindBy(css = "h3.main-title")
    private SelenideElement headerTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainBlockText;

    @FindBy(css = "li.dropdown > a.dropdown-toggle")
    private SelenideElement serviceElementInHeader;

    @FindBy(css = "li.sub-menu > a")
    private SelenideElement serviceElementInLeftMenu;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection imageBlocks;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textBlocks;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection serviceBlockInHeader;

    @FindBy(css = "ul.sub span")
    private ElementsCollection serviceBlockInLeftMenu;

    @FindBy(css = ".logout")
    private SelenideElement logout;

    public void performLogInUser(String username, String password) {
        uiProfileMenu.click();
        loginField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void logout(){
        uiProfileMenu.click();
        logout.click();
    }

    public void checkUserName(String userName) {
        user.shouldHave(text(userName));
    }

    public void checkHeader() {
        headerTitle.shouldHave(text(HEADER));
    }

    public void checkMainText() {
        mainBlockText.shouldHave(text(MAIN_BLOCK_TEXT));
    }

    public void checkPictures() {
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
