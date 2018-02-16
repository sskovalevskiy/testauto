package com.epam.testauto.hw7.enums;

public enum ValuesEven {
    TWO("2"),
    FOUR("4"),
    SIX("6"),
    EIGHT("8");
    public String txt;

    ValuesEven(String s) {
        this.txt = s;
    }
    @Override
    public String toString(){
        return txt;
    }

}
