package com.msaggik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String poem = "У Лукоморья дуб зелёный";
    private int numberOfCharacters;
    private int numberOfWords;
    private int numberOfCharactersL;
    private boolean hasWordsOfLengthFive;
    private String wordsStartingWithA;
    private boolean containsLetterA;

    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = countCharacters(poem);
        numberOfWords = countWords(poem);
        numberOfCharactersL = countCharacterOccurrences(poem, 'л');
        hasWordsOfLengthFive = hasWordsOfLength(poem, 5);
        wordsStartingWithA = concatenateWordsStartingWith(poem, 'а');
        containsLetterA = containsLetter(poem, 'а');

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Число символов в строке " + numberOfCharacters + "\n"
                + "Число слов в строке " + numberOfWords + "\n"
                + "Число букв \"л\" в строке " + numberOfCharactersL + "\n"
                + "Наличие слов из 5 букв: " + hasWordsOfLengthFive + "\n"
                + "Строка из слов, начинающихся на букву \"а\": " + containsLetterA);
    }

    private int countCharacters(String poem) {
        return poem.length();
    }

    private int countWords(String poem) {
        String[] words = poem.split("\\s+");
        return words.length;
    }

    private int countCharacterOccurrences(String poem, char character) {
        int count = 0;
        for (int i = 0; i < poem.length(); i++) {
            if (poem.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    private boolean hasWordsOfLength(String poem, int length) {
        String[] words = poem.split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("[^а-яА-Яa-zA-Z]", "");
            if (cleanWord.length() == length) {
                return true;
            }
        }
        return false;
    }

    private String concatenateWordsStartingWith(String poem, char startingChar) {
        StringBuilder result = new StringBuilder();
        String[] words = poem.split("\\s+");
        for (String word : words) {
            if (word.toLowerCase().startsWith(String.valueOf(startingChar))) {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    private boolean containsLetter(String poem, char letter) {
        return poem.toLowerCase().indexOf(letter) != -1;
    }
}