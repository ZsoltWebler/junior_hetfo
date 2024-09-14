package rgb;

import java.util.Objects;

public class Color {

    private final int red;
    private final int green;
    private final int blue;


    public Color(int red, int green, int blue) {

        if ((red < 0 || red > 255) || (green < 0 || green > 255) || (blue < 0 || blue > 255)) {
            throw new IllegalArgumentException("Color vales must be in the [0,255] interval!");
        }

        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isBright() {
        return (red + green + blue) > 600;
    }

    public int getIntensity() {
        return red + green + blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red && green == color.green && blue == color.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "RGB(" + red +
                ", " + green +
                ", " + blue +
                ')';
    }
}
