package com.epam.testauto.hw7.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.testauto.hw7.User;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginForm extends Form<User> {
    @FindBy(id="Login")
    public TextField login;

    @FindBy(id="Password")
    public TextField password;

    @FindBy(css="[type=submit]")
    public Button enter;

    @FindBy(css = ".profile-photo")
    private Label profilePhoto;

    @FindBy(css = ".profile-photo span")
    private Text profileInfo;

    @FindBy(css = ".fa-sign-out")
    private Label signOut;

    public void logout() {
        if (!signOut.isDisplayed()){
            profilePhoto.click();
        }
        signOut.click();
    }

    public void checkUserInfo(User user) {
        Assert.assertTrue(profileInfo.getText().equalsIgnoreCase(user.getUserName()));
    }
}