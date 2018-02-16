package com.epam.testauto.hw7.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.testauto.hw7.sections.Header;
import org.openqa.selenium.support.FindBy;

public class AbstractPage extends WebPage {

    @FindBy(tagName = "header")
    public Header header;
}
