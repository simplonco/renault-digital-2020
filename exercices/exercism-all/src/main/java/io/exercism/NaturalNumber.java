package io.exercism;

class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    private int getAliqotSum() {
        int aliqotSum = 0;
        for (int i = 1; i < number - 1; i++) {
            if ((number % i) == 0) {
                aliqotSum += i;
            }
        }
        return aliqotSum;
    }

    public Classification getClassification() {
        if (getAliqotSum() == number) {
            return Classification.PERFECT;
        } else if (getAliqotSum() < number) {
            return Classification.DEFICIENT;
        } else {
            return Classification.ABUNDANT;
        }
    }

    enum Classification {

        DEFICIENT, PERFECT, ABUNDANT;

    }

}
