package com.example.demo.bl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.bean.AggStatistics;
import com.example.demo.bean.Statistics;

@Component
public class TextStatistics2 {
    private List<Character> punctuation;

    public TextStatistics2() {
        punctuation = Arrays.asList('.', ',', ';', ':', '-');
    }

    public Statistics processText(String text) {
        Statistics stats = new Statistics();
        stats.setTotalChars(totalCharacters(text));
        stats.setNumChars(numericCharacters(text));
        stats.setAlphaChars(alphaCharacters(text));
        stats.setLowerChars(lowerCaseCharacters(text));
        stats.setUpperChars(upperCaseCharacters(text));
        stats.setWhitespaceChars(whiteSpaceCharacters(text));
        stats.setPunctuationChars(punctuationCharacters(text));
        stats.setWordCount(wordCounter(text));
        stats.setTopTen(letterFrecuency(text));
        return stats;
    }

    private int totalCharacters(String text) {
        return text.length();
    }

    private int numericCharacters(String text) {
        return (int) text.chars().filter(Character::isDigit).count();
    }

    private int alphaCharacters(String text) {
        return (int) text.chars().filter(Character::isLetter).count();
    }

    private int lowerCaseCharacters(String text) {
        return (int) text.chars().filter(Character::isLowerCase).count();
    }

    private int upperCaseCharacters(String text) {
        return (int) text.chars().filter(Character::isUpperCase).count();
    }

    private int whiteSpaceCharacters(String text) {
        return (int) text.chars().filter(Character::isWhitespace).count();
    }

    private int punctuationCharacters(String text) {
        return (int) text.chars().filter(c -> punctuation.contains(c)).count();
    }

    private int wordCounter(String text) {
        String words[] = text.split("\\s+");
        return words.length;
    }

    private Map<Object, Object> letterFrecuency(String text) {
        int total = alphaCharacters(text);
        Map<Character, Long> frecc = text.chars().filter(Character::isLetter).mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Object, Object> result = frecc.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, v -> getAggStatistics(total, v.getValue()),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;

    }

    private AggStatistics getAggStatistics(int total, Long count) {
        AggStatistics agg = new AggStatistics();
        agg.setCount(count);
        agg.setPercentage((count + 0D) / total);
        return agg;
    }
}
