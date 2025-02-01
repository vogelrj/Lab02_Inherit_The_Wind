import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    private SalaryWorker salary_worker;

    @BeforeEach
    void setUp() {
        salary_worker = new SalaryWorker("000001", "Gordon", "Gecko", "Mr.", 1945, 52000.00);
    }

    @Test
    void setAnnualSalary() {
        salary_worker.setAnnualSalary(3.50);
        assertEquals(salary_worker.getAnnualSalary(), 3.50);
    }

    @Test
    void testCalculateWeeklyPay() {
        assertEquals(1000, salary_worker.calculateWeeklyPay(40));
    }

    @Test
    void testToCSV() {
        String expected = "000001, Gordon, Gecko, Mr., 1945, 52000.00";
        assertEquals(expected, salary_worker.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"ID\":\"000001\",\"firstName\":\"Gordon\",\"lastName\":\"Gecko\",\"title\":\"Mr.\",\"YOB\":1945,\"annualSalary\":52000.00}";
        assertEquals(expected, salary_worker.toJSON());
    }

    @Test
    void testToXML() {
        // Omit hourlyPayRate
        String expected = "<SalaryWorker><ID>000001</ID><firstName>Gordon</firstName><lastName>Gecko</lastName><title>Mr.</title><YOB>1945</YOB><annualSalary>52000.00</annualSalary></SalaryWorker>";
        assertEquals(expected, salary_worker.toXML());
    }

}