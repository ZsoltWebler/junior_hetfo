import java.util.Objects;

public class Photo implements Qualified {

    private String name;
    private Quality quality;

    public Photo(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    public Photo(String name) {
        this.name = name;
        this.quality = Quality.NO_STAR;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "name='" + name + '\'' +
                ", quality=" + quality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(name, photo.name) && quality == photo.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quality);
    }
}
