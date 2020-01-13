import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.isBlank()) {
            return "";
        }
        StringBuilder transcription = new StringBuilder();
        for (char nucleotide : dnaStrand.toCharArray()) {
            switch (nucleotide) {
                case 'G':
                    transcription.append("C");
                    break;
                case 'C':
                    transcription.append("G");
                    break;
                case 'T':
                    transcription.append("A");
                    break;
                case 'A':
                    transcription.append("U");
                    break;
                default:
                    throw new IllegalArgumentException("unknown nucleotide " + nucleotide);
            }
        }
        return transcription.toString();
    }

}
