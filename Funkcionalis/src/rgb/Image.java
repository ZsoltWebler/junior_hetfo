package rgb;

import java.util.List;

public class Image {

    private final List<List<Color>> pixels;

    public Image(List<List<Color>> pixels) {
        this.pixels = pixels;
    }

    public Color getColor(int row, int column) {
        return pixels.get(row - 1).get(column - 1);
    }
}
