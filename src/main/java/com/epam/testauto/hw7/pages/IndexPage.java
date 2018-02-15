package com.epam.testauto.hw7.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import org.openqa.selenium.support.FindBy;

//@JPage(url = "/index.htm", title = "Index Page")
public class IndexPage extends AbstractPage {

    @FindBy(css = "div.profile-photo > span")
    private Text username;

    public void checkUserName() {
        username.getText();
    }


}