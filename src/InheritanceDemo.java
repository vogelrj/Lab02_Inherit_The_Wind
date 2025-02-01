import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {

        //Worker classes
        Worker hourly_worker1 = new Worker("000001", "Dwayne", "Hicks", "CPL", 2000, 25.00);
        Worker hourly_worker2 = new Worker("000002", "William", "Hudson", "PFC", 2004, 18.00);
        Worker hourly_worker3 = new Worker("000003", "Julia", "Vasquez", "PVT", 2009, 16.00);

        //SalaryWorker classes
        SalaryWorker salary_worker1 = new SalaryWorker("000004", "Ellen", "Ripley", "CPT", 1996, 35.00);
        SalaryWorker salary_worker2 = new SalaryWorker("000005", "Bradley", "Gorman", "2LT", 2000, 30.00);
        SalaryWorker salary_worker3 = new SalaryWorker("000006", "Carter" ,"Burke", "Dr.", 1991, 45.00);

        //Create ArrayList of all Classes
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(hourly_worker1);
        workers.add(hourly_worker2);
        workers.add(hourly_worker3);
        workers.add(salary_worker1);
        workers.add(salary_worker2);
        workers.add(salary_worker3);

        //Loop through 3 paychecks of 40hrs, 50hrs and 40hrs

        double[] weeklyhours = {40.0, 50.0, 40.0};

        for (int i = 0; i < weeklyhours.length; i++) {
            double hours = weeklyhours[i];
            System.out.printf("\nWeek %d:  %.2f hours\n", (i + 1), hours);
            System.out.println("-------------------------");
            for (Worker employee : workers) {
                employee.displayWeeklyPay(hours);
                System.out.println();
            }
        }
    }
}
