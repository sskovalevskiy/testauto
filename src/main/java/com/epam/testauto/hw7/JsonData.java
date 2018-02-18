package com.epam.testauto.hw7;

import com.epam.testauto.hw7.enums.Colors;
import com.epam.testauto.hw7.enums.Elements;
import com.epam.testauto.hw7.enums.Metals;
import com.epam.testauto.hw7.enums.Vegetables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonData {
    private String[] summary;
    private Elements[] elements;
    private Colors color;
    private Metals metal;
    private Vegetables[] vegetables;

    public String[] getSummary() {
        return summary;
    }

    public Elements[] getElements() {
        return elements;
    }

    public Colors getColor() {
        return color;
    }

    public Metals getMetal() {
        return metal;
    }

    public Vegetables[] getVegetables() {
        return vegetables;
    }

    public List<String> getStrings() {

        List<String> strings = new ArrayList<>();
        strings.add("Summary: " + (Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])));
        strings.add("Elements: " + Arrays.toString(elements).replace("[", "").replace("]", ""));
        strings.add("Color: " + color);
        strings.add("Metal: " + metal);
        strings.add("Vegetables: " + Arrays.toString(vegetables).replace("[", "").replace("]", ""));
        return strings;
    }

    @Override
    public String toString() {
        return "Summary: " + (Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])) + "\n" +
                "Elements: " + Arrays.toString(elements).replaceAll("\\[|\\]", "") + "\n" +
                "Color: " + color + "\n" +
                "Metal: " + metal + "\n" +
                "Vegetables: " + Arrays.toString(vegetables).replace("\\[|\\]", "");
    }
}