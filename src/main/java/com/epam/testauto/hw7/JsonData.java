package com.epam.testauto.hw7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonData {
    private String[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public String[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public List<String> getStrings() {

        List<String> strings = new ArrayList<>();
        strings.add("Summary: " + (Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])));
        strings.add("Elements: " + Arrays.toString(elements).replace("[", "").replace("]", ""));
        strings.add("Color: " + color);
        strings.add("Metal: " + metals);
        strings.add("Vegetables: " + Arrays.toString(vegetables).replace("[", "").replace("]", ""));
        return strings;
    }

    @Override
    public String toString() {
        return "Summary: " + (Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])) + "\n" +
                "Elements: " + Arrays.toString(elements).replaceAll("\\[|\\]", "") + "\n" +
                "Color: " + color + "\n" +
                "Metal: " + metals + "\n" +
                "Vegetables: " + Arrays.toString(vegetables).replace("\\[|\\]", "");
    }
}