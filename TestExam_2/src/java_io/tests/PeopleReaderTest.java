package java_io.tests;

import org.junit.jupiter.api.Test;
import java_io.Gender;
import java_io.People;
import java_io.PeopleReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PeopleReaderTest {

    private final String filePath = "src/java_io/people.csv";
    List<People> peopleList = PeopleReader.readPeoplesFromCsv(new File(filePath));

    public PeopleReaderTest() throws FileNotFoundException {
    }


    @Test
    public void peopleReadTest_1() {
        assertEquals(peopleList.size(), 1000);
    }

    @Test
    public void peopleReadTest_2() {
        assertEquals(peopleList.get(0), new People(1, "Rebekkah", "Lashmore", "rlashmore0@rambler.ru", Gender.MALE, "140.220.218.69"));
        assertEquals(peopleList.get(300), new People(301, "Stuart", "Berthe", "sberthe8c@msu.edu", Gender.MALE, "214.245.207.187"));
    }

    @Test
    public void peopleReadTest_3() {
        assertEquals(peopleList.stream().map(People::getFirstName).distinct().toList().size(), 934);
        assertEquals(peopleList.stream().map(People::getLastName).distinct().toList().size(), 987);
    }

    @Test
    public void peopleReadTest_4() {
        assertEquals(peopleList.stream().map(People::getEmail).filter(mail -> mail.endsWith(".ru")).toList().size(), 19);
        assertEquals(peopleList.stream().map(People::getEmail).filter(mail -> mail.endsWith(".edu")).toList().size(), 55);
        assertEquals(peopleList.stream().map(People::getEmail).filter(mail -> mail.endsWith(".com")).toList().size(), 598);
    }

    @Test
    public void peopleReadTest_5() {
        Map<Gender, List<People>> collect = peopleList.stream().collect(Collectors.groupingBy(People::getGender));

        assertEquals(545,collect.get(Gender.MALE).size());
        assertEquals(455,collect.get(Gender.FEMALE).size());

    }
}
