import java.util.Comparator;

public class StringLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
