import java.util.Objects;

public class PropertyChangeEvent {

    private final String oldValue;
    private final String newValue;

    public PropertyChangeEvent(String oldValue, String newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    @Override
    public String toString() {
        return "PropertyChangeEvent{" +
                "oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyChangeEvent that = (PropertyChangeEvent) o;
        return Objects.equals(oldValue, that.oldValue) && Objects.equals(newValue, that.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldValue, newValue);
    }
}
