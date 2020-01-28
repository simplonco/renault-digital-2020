package co.simplon.exercices.lego;

public class Application {

    /**
     * Do not change.
     */
    private final static String[] TOP = {"╔═", "══", "╗"};

    /**
     * Do not change.
     */
    private final static String[] INTERMEDIATE = {"║ ", "O ", "║"};

    /**
     * Do not change.
     */
    private final static String[] BOTTOM = {"╚═", "══", "╝"};

    /**
     * Main method, do not change but the brick's dimensions.
     */
    public static void main(String[] args) {
        // Hard-coded example of a 2x4 brick
        System.out.println("Hard-coded example:");
        System.out.println("╔═════════╗");
        System.out.println("║ O O O O ║");
        System.out.println("║ O O O O ║");
        System.out.println("╚═════════╝");
        System.out.println("╔═══════════╗");
        System.out.println("║ O O O O O ║");
        System.out.println("║ O O O O O ║");
        System.out.println("║ O O O O O ║");
        System.out.println("╚═══════════╝");
        System.out.println("Brain-coded example:");
        // Can change to test other dimensions
        LegoBrick brick = new LegoBrick(5, 12);
        displayBrick(brick);
    }

    /**
     * Displays the given {@code LegoBrick} into the console.
     * <p>
     * Should work what ever the {@code brick}'s dimensions are.
     * <p>
     * Implementation should not declare another {@code StringBuilder} neither
     * use concatenation, and the one that is already declared should be the one
     * printed.
     * <p>
     * Make use of the 3 arrays declared as constants in this class.
     */
    private static void displayBrick(LegoBrick brick) {
        StringBuilder sb = new StringBuilder();

        addBrickBlocks(brick, sb, TOP);
        for (int indexHeight = 0; indexHeight < brick.getHeight(); indexHeight++) {
            addBrickBlocks(brick, sb, INTERMEDIATE);
        }
        addBrickBlocks(brick, sb, BOTTOM);

        System.out.print(sb);
    }

    private static void addBrickBlocks(LegoBrick brick, StringBuilder sb, String[] position) {
        sb.append(position[0]);
        sb.append(position[1].repeat(brick.getWidth()));
        sb.append(position[2]);
        sb.append('\n');
    }

}

