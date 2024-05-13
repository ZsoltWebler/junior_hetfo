import java.util.List;

public class PhotoCollection {
    private final List<Photo> photos;

    public PhotoCollection(List<Photo> photos) {
        this.photos = photos;
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public void listPhotos() {
        for (Photo photo : photos) {
            System.out.println(photo.getName() + ", " + photo.getQuality());
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
            }
        }
        throw new PhotoNotFoundException();
    }

    public int numberOfStars() {
        int count = 0;
        for (Photo photo : photos) {
            if (photo.getQuality().equals(Quality.NO_STAR)) {
            }
            if (photo.getQuality().equals(Quality.ONE_STAR)) {
                count += 1;
            }
            if (photo.getQuality().equals(Quality.TWO_STAR)) {
                count += 2;
            }
        }
        return count;
    }
}
