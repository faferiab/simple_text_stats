package com.example.demo.bean;

import java.util.Map;

public class Statistics {

    private int totalChars;
    private int numChars;
    private int alphaChars;
    private int upperChars;
    private int lowerChars;
    private int whitespaceChars;
    private int punctuationChars;
    private int wordCount;
    private Map<Object, Object> topTen;

    public int getTotalChars() {
        return totalChars;
    }

    public void setTotalChars(int totalChars) {
        this.totalChars = totalChars;
    }

    public int getNumChars() {
        return numChars;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

    public int getAlphaChars() {
        return alphaChars;
    }

    public void setAlphaChars(int alphaChars) {
        this.alphaChars = alphaChars;
    }

    public int getUpperChars() {
        return upperChars;
    }

    public void setUpperChars(int upperChars) {
        this.upperChars = upperChars;
    }

    public int getLowerChars() {
        return lowerChars;
    }

    public void setLowerChars(int lowerChars) {
        this.lowerChars = lowerChars;
    }

    public int getWhitespaceChars() {
        return whitespaceChars;
    }

    public void setWhitespaceChars(int whitespaceChars) {
        this.whitespaceChars = whitespaceChars;
    }

    public int getPunctuationChars() {
        return punctuationChars;
    }

    public void setPunctuationChars(int punctuationChars) {
        this.punctuationChars = punctuationChars;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Map<Object, Object> getTopTen() {
        return topTen;
    }

    public void setTopTen(Map<Object, Object> topTen) {
        this.topTen = topTen;
    }

}
