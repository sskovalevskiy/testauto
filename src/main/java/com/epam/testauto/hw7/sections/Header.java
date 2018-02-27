package com.epam.testauto.hw7.sections;

import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.testauto.hw7.enums.Pages;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".m-l8")
    public JDIHeaderMenu<Pages> menu;

    public LoginForm loginForm;
}
