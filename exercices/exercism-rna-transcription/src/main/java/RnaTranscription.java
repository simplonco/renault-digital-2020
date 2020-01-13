class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.equals("")) {
            return "";
        } else if(dnaStrand.equals("C")) {
            return "G";
        }
        String rnaStrand = "";
        for (char element : dnaStrand.toCharArray()) {
            switch (element) {
                case 'C':
                    rnaStrand = rnaStrand + "G";
                    break;
                default:
                    throw new IllegalArgumentException("unknown char " + element);
            }
        }
        return  rnaStrand;
    }
}
