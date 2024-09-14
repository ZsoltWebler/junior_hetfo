package rgb;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Image {

    private final List<List<Color>> pixels;

    public Image(List<List<Color>> pixels) {
        this.pixels = pixels;
    }

    public Color getColor(int row, int column) {
        return pixels.get(row - 1).get(column - 1);
    }

    public int getHeight() {
        return pixels.size();
    }

    public int getWidth() {
        return pixels.get(0).size();
    }

    public int getBrightPixelCount() {

        int brightPixelCounter = 0;
        for (int i = 0; i < pixels.size(); i++) {
            List<Color> row = pixels.get(i);
            for (int j = 0; j < row.size(); j++) {
                Color color = row.get(j);
                brightPixelCounter += color.isBright() ? 1 : 0;
            }
        }

        long brightPixelCount_ = pixels.stream()
                .flatMap(Collection::stream)
                .filter(Color::isBright)
                .count();

        return brightPixelCounter;
    }

    public Color darkestColorIntensity() {
        return pixels.stream()
                .flatMap(Collection::stream)
                .min(Comparator.comparingInt(Color::getIntensity))
                .orElseThrow();
    }

    public List<Color> listOfDarkestColors() {
        int darkestIntensity = darkestColorIntensity().getIntensity();

        return pixels.stream()
                .flatMap(Collection::stream)
                .filter(color -> color.getIntensity() == darkestIntensity)
                .toList();

    }

    public boolean border(int rowIndex, int intensityValue) {
        List<Color> row = pixels.get(rowIndex - 1);


        for (int i = 0; i < row.size() - 1; i++) {

            if (Math.abs(row.get(i).getIntensity() - row.get(i + 1).getIntensity()) > intensityValue) {
                return true;
            }
        }
        return false;
    }

    public void writeImageToFile() throws IOException {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {

                if(y != 102){
                    int rgb = pixels.get(y).get(x).getRed();
                    rgb = (rgb << 8) + pixels.get(y).get(x).getGreen();
                    rgb = (rgb << 8) + pixels.get(y).get(x).getBlue();
                    image.setRGB(x, y, rgb);
                }else{
                    image.setRGB(x, y, java.awt.Color.RED.getRGB());
                }


            }
        }

        File outputFile = new File("src/rgb/output.bmp");
        ImageIO.write(image, "bmp", outputFile);
    }

}
