package io.exercism;

class Acronym {

    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase
                .replace("-", " ")
                .replace("_", " ");
    }

    String get() {
        String acronyme = "";
        String[] words = phrase.split(" ");
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            if (!word.isBlank()) {
                char firstCharacter = word.charAt(0);
                acronyme += firstCharacter;
            }
        }
        return acronyme.toUpperCase();
    }

}

