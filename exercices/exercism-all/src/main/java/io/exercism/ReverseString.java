package io.exercism;

class ReverseString {

    String reverse(String inputString) {
        char[] chars = inputString.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int index = chars.length - 1; index >= 0; index--) {
            char letter = chars[index];
            result.append(letter);
        }
        return result.toString();
    }
  
}