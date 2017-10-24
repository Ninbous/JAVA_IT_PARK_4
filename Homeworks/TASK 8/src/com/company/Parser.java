package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parser implements Observed {

    Observer observer[];

    public String[] parse(String str) {
        String[] words = new String[10];
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i <= chars.length - 1; i++) {
            if (chars[i] != ' ') {
                stringBuilder.append(chars[i]);
            } else {
                words[count] = stringBuilder.toString();
                count++;
                stringBuilder = new StringBuilder();
            }
            words[count] = stringBuilder.toString();
        }

        return words;
    }


    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
