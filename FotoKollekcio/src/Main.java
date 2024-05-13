public class Main {
    public static void main(String[] args) {

        PhotoCollection photoCollection = new PhotoCollection();

        photoCollection.addPhoto(new Photo("Tisza",Quality.TWO_STAR));
        photoCollection.addPhoto(new Photo("Duna",Quality.ONE_STAR));
        photoCollection.addPhoto(new Photo("Mátra"));
        photoCollection.addPhoto(new Photo("Börzsöny",Quality.TWO_STAR));
        photoCollection.addPhoto(new Photo("Balaton",Quality.TWO_STAR));


        photoCollection.listPhotos();

        System.out.println(photoCollection.numberOfStars());

    }
}