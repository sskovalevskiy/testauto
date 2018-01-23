package com.epam.testauto;

public enum TextBlock {

    FIRST_BLOCK("To include good practices and ideas from successful EPAM projec"),
    SECOND_BLOCK("To be flexible and customizable"),
    THIRD_BLOCK("To be multiplatform"),
    FORTH_BLOCK("Already have good base (about 20 internal and some external projects), wish to get more…");

    public final String text;

    TextBlock(String text) {
        this.text = text;
    }
}
