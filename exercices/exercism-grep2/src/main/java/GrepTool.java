import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class GrepTool {

    public static void main(String... args) {
        String pattern = args[0];
        String flag = args[1];
        String file = args[2];
        GrepTool grepTool = new GrepTool();
        String grep = grepTool.grep(pattern, List.of(flag), List.of(file));
        System.out.println(grep);
    }

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for (String file : files) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file));
                for (String line : lines) {
                    if (line.contains(pattern)) {
                        if (flags.contains("-n")) {
                            result.append(counter).append(":");
                        }
                        result.append(line).append('\n');
                    }
                    counter++;
                }
            } catch (IOException e) {
                System.err.println("Exception durant la lecture fichier pour grep " + e.getMessage());
            }
        }
        return result.substring(0, result.length() - 1);
    }

}