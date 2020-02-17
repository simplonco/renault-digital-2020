package io.exercism;

import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = getAliquotSum();
        if (sum == number) {
            return Classification.PERFECT;
        } else if (sum > number) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }

    private int getAliquotSum() {
        return IntStream.range(1, number)
                .filter(i -> number % i == 0)
                .sum();
    }

    enum Classification {

        DEFICIENT, PERFECT, ABUNDANT

    }

}
