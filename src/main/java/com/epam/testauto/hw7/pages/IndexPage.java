package com.epam.testauto.hw7.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends AbstractPage {

    @FindBy(css = "div.profile-photo > span")
    private Text username;

    public String getUserName() {
        return username.getText();
    }

}