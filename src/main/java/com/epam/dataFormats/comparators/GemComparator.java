package com.epam.dataFormats.comparators;

import com.epam.dataFormats.generatedClasses.Gem;

import java.util.Comparator;

public class GemComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem o1, Gem o2) {
        return o1.getValue() - o2.getValue();
    }
}
