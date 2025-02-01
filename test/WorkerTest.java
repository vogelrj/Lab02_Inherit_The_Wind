import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    private Worker hourly_worker;

    @BeforeEach
    void setUp() {
        hourly_worker = new Worker("000001", "Michael", "Douglas", "Mr.", 1940, 40.00);
    }


    @Test
    void testSetHourlyPayRate() {
        hourly_worker.setHourlyPayRate(45.25);
        assertEquals(45.25, hourly_worker.getHourlyPayRate());
    }

    @Test
    void testCalculateWeeklyPayRate() {
        assertEquals(1600.00, hourly_worker.calculateWeeklyPay(40));
        assertEquals(2200.00, hourly_worker.calculateWeeklyPay(50));
    }

    @Test
    void testToCSV() {
        String expected = "000001, Michael, Douglas, Mr., 1940, 40.00";
        assertEquals(expected, hourly_worker.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"ID\":\"000001\",\"firstName\":\"Michael\",\"lastName\":\"Douglas\",\"title\":\"Mr.\",\"YOB\":1940,\"hourlyPayRate\":40.00}";
        assertEquals(expected, hourly_worker.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Worker><ID>000001</ID><firstName>Michael</firstName><lastName>Douglas</lastName><title>Mr.</title><YOB>1940</YOB><hourlyPayRate>40.00</hourlyPayRate></Worker>";
        assertEquals(expected, hourly_worker.toXML());
    }

}