package com.example.demo;

import org.thymeleaf.spring6.util.DetailedError;

import java.util.Comparator;

public class DetailedErrorComparator implements Comparator<DetailedError> {

    @Override
    public int compare(DetailedError e1, DetailedError e2) {
        return e1.getFieldName().compareTo(e2.getFieldName());
    }
}
