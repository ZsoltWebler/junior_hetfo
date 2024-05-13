public class Photo implements Qualified{
    private Quality quality;

    private final String name;

    public Photo(Quality quality, String name) {
        this.quality = quality;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
