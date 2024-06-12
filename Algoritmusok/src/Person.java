import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private final List<PropertyChangeListener> propertyChangeListenerList = new ArrayList<>();

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        fireEvent(this.name, name);
        this.name = name;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeListenerList.add(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeListenerList.remove(propertyChangeListener);
    }

    private void fireEvent(String oldValue, String newValue) {
        for (PropertyChangeListener listener : propertyChangeListenerList) {
            listener.onPropertyChange(new PropertyChangeEvent(oldValue, newValue));
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
