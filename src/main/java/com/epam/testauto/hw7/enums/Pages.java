package com.epam.testauto.hw7.enums;

import java.util.Objects;

public enum Pages {
    HOME, CONTACT_FORM, METALS_COLORS("Metals & Colors"), SERVICE, SUPPORT(2), DATES(2), COMPLEX_TABLE(2), SIMPLE_TABLE(2), TABLE_WITH_PAGES(2), DIFFERENT_ELEMENTS(2);

    private int level;
    private String name;

    Pages() {
        this(1);
    }

    Pages(String name) {
        this.name = name;
    }

    Pages(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        if (!Objects.isNull(name))
            return name;
        else
            return name().replaceAll("_", " ");
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
