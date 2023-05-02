package com.example.word.model;

public class Word extends Item {
    private String englishWord;
    private String chineseMeaning;
    private String exampleSentences;
    private String source;
    private String title;

    public Word(String englishWord, String chineseMeaning, String exampleSentences, String source, String title) {
        this.englishWord = englishWord;
        this.chineseMeaning = chineseMeaning;
        this.exampleSentences = exampleSentences;
        this.source = source;
        this.title = title;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getChineseMeaning() {
        return chineseMeaning;
    }

    public String getExampleSentences() {
        return exampleSentences;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }
}
