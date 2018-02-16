package com.epam.testauto.hw7.enums;

import java.util.ArrayList;

public enum ResultText {
    SUMMARY("Summary: 11"),
    ELEMENTS("Elements: Water, Fire"),
    COLOR("Color: Red"),
    METAL("Metal: Selen"),
    VEGETABLES("Vegetables: Cucumber, Tomato");

    private static ArrayList<String> textList = new ArrayList<>();
    private String txt;

    ResultText(String s) {
        this.txt = s;
    }

    public static ArrayList<String> getTextList(){
        for (ResultText textElement: ResultText.values()){
            textList.add(textElement.txt);
        }
        return textList;
    }
}
