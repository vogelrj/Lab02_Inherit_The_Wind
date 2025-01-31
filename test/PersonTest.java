import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person p1;
    private Person p2;
    private Person p3;
    private Person p4;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Martin", "Brody", "Chief", 1949);
        p2 = new Person("000002", "Sam", "Quint", "Captain", 1940);
        p3 = new Person("000003", "Matt", "Hooper", "Dr.", 1950);
        p4 = new Person("000004", "Bruce", "Shark", "Hon.", 2000);
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Steven");
        assertEquals("Steven", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Spielberg");
        assertEquals("Spielberg", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Director");
        assertEquals("Director", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1975);
        assertEquals(1975, p1.getYOB());
    }

    @Test
    void fullName() {
        assertEquals("Matt Hooper", p3.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Hon. Bruce Shark", p4.formalName());
    }

    @Test
    void getAge() {
        assertEquals("25", p4.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals("37", p3.getAge(1987));
    }

    @Test
    void testToString() {
        String p2_str = "Person{ID='000002', firstName='Sam', lastName='Quint', title='Captain', YOB=1940}";
        assertEquals(p2_str, p2.toString());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000003, Matt, Hooper, Dr., 1950", p3.toCSV());
    }

    @Test
    void testToJSON() {
        String expected1 = "{\"ID\":\"000003\",\"firstName\":\"Matt\",\"lastName\":\"Hooper\",\"title\":\"Dr.\",\"YOB\":1950}";
        assertEquals(expected1, p3.toJSON());

    }

    @Test
    void testToXML() {
        String expected1 = "<Person><ID>000003</ID><firstName>Matt</firstName><lastName>Hooper</lastName><title>Dr.</title><YOB>1950</YOB></Person>";
        assertEquals(expected1, p3.toXML());
    }
    }