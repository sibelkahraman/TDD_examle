package org.bootcamp.w3;

import java.util.*;

public class WordCount {
    public int counter(String sentence) {

        sentence = sentence.toLowerCase();
        String replacePunctuations = sentence.replaceAll("[.,]","");
        String[] words = replacePunctuations.split("\\s+");
        List list = new ArrayList();
        Collections.addAll(list, words);
        Set<WordCount> wordSet = new HashSet<WordCount>(list);

        return wordSet.size();
    }
}
