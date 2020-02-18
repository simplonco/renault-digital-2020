package io.exercism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Scrabble {

    private String word;
    private Map<Character, Integer> points = new HashMap<>();

    Scrabble(String word) {
        this.word = word.toUpperCase();
        for (Character character : List.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')) {
            points.put(character, 1);
        }
        for (Character character : List.of('D', 'G')) {
            points.put(character, 2);
        }
        for (Character character : List.of('B', 'C', 'M', 'P')) {
            points.put(character, 3);
        }
        for (Character character : List.of('F', 'H', 'V', 'W', 'Y')) {
            points.put(character, 4);
        }
        for (Character character : List.of('K')) {
            points.put(character, 5);
        }
        for (Character character : List.of('J', 'X')) {
            points.put(character, 8);
        }
        for (Character character : List.of('Q', 'Z')) {
            points.put(character, 10);
        }
    }

    int getScore() {
        int score = 0;
        for (Character letter: word.toCharArray()) {
            score += points.get(letter);
        }
        return score;
    }

/*
Letter                           Value
A, E, I, O, U, L, N, R, S, T       1
D, G                               2
B, C, M, P                         3
F, H, V, W, Y                      4
K                                  5
J, X                               8
Q, Z                               10

 */
}
