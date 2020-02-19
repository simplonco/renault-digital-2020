package io.exercism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Scrabble {

    private String word;

    private Map<Character, Integer> map = new HashMap<>();

    {
        for (Character character : List.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')) {
            map.put(character, 1);
        }
        for (Character character : List.of('D', 'G')) {
            map.put(character, 2);
        }
        for (Character character : List.of('B', 'C', 'M', 'P')) {
            map.put(character, 3);
        }
        for (Character character : List.of('F', 'H', 'V', 'W', 'Y')) {
            map.put(character, 4);
        }
        for (Character character : List.of('K')) {
            map.put(character, 5);
        }
        for (Character character : List.of('J', 'X')) {
            map.put(character, 8);
        }
        for (Character character : List.of('Q', 'Z')) {
            map.put(character, 10);
        }
    }

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        int score = 0;
        for (char letter : word.toCharArray()) {
            score += map.get(letter);
        }
        return score;
    }

}
