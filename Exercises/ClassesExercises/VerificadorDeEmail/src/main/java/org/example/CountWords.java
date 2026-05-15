package org.example;

public class CountWords {


    public static int countWords(String phrase, String searchedWord) {
        if (phrase.isEmpty() || searchedWord.isEmpty()) return 0;

        String[] words = phrase.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.replaceAll("[,.]", " ").trim().equals(searchedWord)) {
                count++;
            }
        }
        return count;
    }
}
