package co.simplon.exercices.lego;

/**
 * Do not change this class.
 */
public class LegoBrick {

  private final int height;

  private final int width;

  public LegoBrick(int height, int width) {
    if (height < 1 || width < 1) {
      throw new IllegalArgumentException("height and width must be >= 1");
    }
    this.height = height;
    this.width = width;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}

