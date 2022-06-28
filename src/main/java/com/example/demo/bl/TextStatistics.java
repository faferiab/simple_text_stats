package com.example.demo.bl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Statistics;

@Component
public class TextStatistics {
    private List<Character> punctuation;

    public TextStatistics() {
        punctuation = Arrays.asList('.', ',', ';', ':', '-');
    }

    public Statistics processText(String text) {
        Statistics stats = new Statistics();
        stats.setTotalChars(totalCharacters(text));
        for (int idx = 0; idx < text.length(); idx++) {
            stats.setNumChars(stats.getNumChars() + numericCharacters(text.charAt(idx)));
            stats.setAlphaChars(stats.getAlphaChars() + alphaCharacters(text.charAt(idx)));
            stats.setLowerChars(stats.getLowerChars() + lowerCaseCharacters(text.charAt(idx)));
            stats.setUpperChars(stats.getUpperChars() + upperCaseCharacters(text.charAt(idx)));
            stats.setWhitespaceChars(stats.getWhitespaceChars() + whiteSpaceCharacters(text.charAt(idx)));
            stats.setPunctuationChars(stats.getPunctuationChars() + punctuationCharacters(text.charAt(idx)));
        }

        stats.setWordCount(wordCounter(text));
        return stats;
    }

    private int totalCharacters(String text) {
        return text.length();
    }

    private int numericCharacters(char character) {
        if (Character.isDigit(character))
            return 1;
        return 0;
    }

    private int alphaCharacters(char character) {
        if (Character.isLetter(character))
            return 1;
        return 0;
    }

    private int lowerCaseCharacters(char character) {
        if (Character.isLowerCase(character))
            return 1;
        return 0;
    }

    private int upperCaseCharacters(char character) {
        if (Character.isUpperCase(character))
            return 1;
        return 0;
    }

    private int whiteSpaceCharacters(char character) {
        if (Character.isWhitespace(character))
            return 1;
        return 0;
    }

    private int punctuationCharacters(char character) {
        if (punctuation.contains(character))
            return 1;
        return 0;
    }

    private int wordCounter(String text) {
        String words[] = text.split("\\s+");
        return words.length;
    }
}
