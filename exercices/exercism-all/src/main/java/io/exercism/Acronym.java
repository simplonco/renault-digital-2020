package io.exercism;

class Acronym {

    String phrase;

    Acronym(String phrase) {
        this.phrase = phrase.toUpperCase().replaceAll("[-_]", " ");
    }

    String get() {
        String[] words = this.phrase.split(" ");
        StringBuilder acronym = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                acronym.append(word.charAt(0));
            }
        }
        return acronym.toString();
    }

}
