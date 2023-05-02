package com.example.word.vocabulary;

import com.example.word.model.ItemsManager;
import com.example.word.model.Word;

public class VocabularyManager extends ItemsManager<Word> {

    private static VocabularyManager instance;

    private VocabularyManager() {}

    public static VocabularyManager getInstance() {
        if (instance == null) {
            instance = new VocabularyManager();
        }
        return instance;
    }
}
