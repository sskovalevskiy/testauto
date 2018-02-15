package com.epam.testauto.hw7.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".m-l8")
    public static Menu menu;

    public static LoginForm loginForm;
}
