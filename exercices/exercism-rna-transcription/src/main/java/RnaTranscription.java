class RnaTranscription {


    /**
     * on recoit "GCT" il faut retourner "CGA"
     * G -> C
     * C -> G
     * T -> A
     */
    String transcribe(String dnaStrand) { // dnaString = "GCT"
        if (dnaStrand == null) {
            throw new NullPointerException("dnastrand cannot be null");
        }
        if(dnaStrand.equals("")) {
            return "";
        }
        String result = "";
        for (char element : dnaStrand.toCharArray()) {
            switch (element) {
                case 'G':
                    result = result + "C";
                    break;
                case 'C':
                    result = result + "G";
                    break;
                default:
                    throw new IllegalArgumentException("unknown char " + element);
            }
        }
        return result;
    }

}
