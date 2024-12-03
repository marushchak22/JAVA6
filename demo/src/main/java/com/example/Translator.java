package com.example;


import java.util.HashMap;
import java.util.Scanner;

public class Translator {
    private HashMap<String, String> dictionary;

    // Конструктор
    public Translator() {
        dictionary = new HashMap<>();
    }

    // Метод для додавання пар слів
    public void addWord(String englishWord, String ukrainianWord) {
        dictionary.put(englishWord.toLowerCase(), ukrainianWord.toLowerCase());
    }

    // Метод для перекладу фрази
    public String translatePhrase(String phrase) {
        String[] words = phrase.toLowerCase().split(" ");
        StringBuilder translatedPhrase = new StringBuilder();
        
        for (String word : words) {
            String translatedWord = dictionary.getOrDefault(word, "[" + word + "]");
            translatedPhrase.append(translatedWord).append(" ");
        }
        return translatedPhrase.toString().trim();
    }

    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Наповніть словник. Для завершення введіть 'exit'.");
        while (true) {
            System.out.print("Введіть слово англійською: ");
            String englishWord = scanner.nextLine();
            if (englishWord.equalsIgnoreCase("exit")) break;

            System.out.print("Введіть переклад українською: ");
            String ukrainianWord = scanner.nextLine();
            translator.addWord(englishWord, ukrainianWord);
        }

        System.out.println("\nСловник готовий! Введіть фразу англійською для перекладу:");
        String phrase = scanner.nextLine();
        String translatedPhrase = translator.translatePhrase(phrase);

        System.out.println("Переклад: " + translatedPhrase);
    }
}
