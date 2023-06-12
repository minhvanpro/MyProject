package com.example.news.utils;

import java.text.Normalizer;

public class Utils {
    public static String generateCode(String name) {
        return  Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase()
                .replaceAll("đ", "d")
                .replaceAll(" ", "-");
    }
}
