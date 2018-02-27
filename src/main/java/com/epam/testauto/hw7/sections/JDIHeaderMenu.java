package com.epam.testauto.hw7.sections;


import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.testauto.hw7.enums.Pages;

public class JDIHeaderMenu<T extends Pages> extends Menu<T> {

    public void selectItem(T item) {
        if(item.getLevel() == 2)
            super.select(T.SERVICE.toString());
        super.select(item.toString());
    }
}