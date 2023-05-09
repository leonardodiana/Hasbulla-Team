package com.onnis.utils;

public class TextUtils {
    public static String[] longestWords(String text) {
        String[] sentences = text.split("(?<!\\d)\\.(?!\\d)|\\?|!");
        String[] longestWords = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            longestWords[i] = longestWord(sentences[i]);
        }
        return longestWords;
    }

    public static String longestWord(String text) {
        String[] words = text.split("[\\p{Punct}&&[^.]]+|\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}

