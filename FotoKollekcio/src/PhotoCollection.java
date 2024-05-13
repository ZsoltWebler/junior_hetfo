import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private final List<Photo> photoList;

    public PhotoCollection() {
        this.photoList = new ArrayList<>();
    }

    public boolean addPhoto(Photo photo) {
        return photoList.add(photo);
    }

    public void listPhotos() {


        for (Photo photo : photoList) {
            String starString = "";

            switch (photo.getQuality()) {
                case ONE_STAR:
                    starString = "*";
                    break;
                case TWO_STAR:
                    starString = "**";
                    break;
            }
            System.out.println(photo.getName() + " - " + starString);
        }

    }

    public int numberOfStars() {

        int allStarCount = 0;

        for (Photo photo : photoList) {
            int starCount = 0;

            switch (photo.getQuality()) {
                case ONE_STAR:
                    starCount = 1;
                    break;
                case TWO_STAR:
                    starCount = 2;
                    break;
            }
            allStarCount += starCount;
        }

        return allStarCount;
    }
}
