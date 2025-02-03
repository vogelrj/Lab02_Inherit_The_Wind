import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {

        //Worker classes and ArrayList
        ArrayList<Worker> hourlyWorkers = new ArrayList<>();
        hourlyWorkers.add(new Worker("000001", "Dwayne", "Hicks", "CPL", 2000, 25.00));
        hourlyWorkers.add(new Worker("000002", "William", "Hudson", "PFC", 2004, 18.00));
        hourlyWorkers.add(new Worker("000003", "Julia", "Vasquez", "PVT", 2009, 16.00));

        //SalaryWorker classes and ArrayList
        ArrayList<SalaryWorker> salaryWorkers = new ArrayList<>();
        salaryWorkers.add(new SalaryWorker("000004", "Ellen", "Ripley", "CPT", 1996, 85000.00));
        salaryWorkers.add(new SalaryWorker("000005", "Bradley", "Gorman", "2LT", 2000, 70000.00));
        salaryWorkers.add(new SalaryWorker("000006", "Carter" ,"Burke", "Dr.", 1991, 125000.00));

        // 3 pay periods: 40, 50, 40 hours
        double[] weeklyhours = {40.0, 50.0, 40.0};

        // Loop through each pay period and print tables for each class
        for (int i = 0; i < weeklyhours.length; i++) {
            double hours = weeklyhours[i];

            System.out.printf("\n=== Pay Week %d (%.2f hrs) ===\n", (i + 1), hours);
            System.out.println("\nHourly Workers:\n");
            System.out.printf("%-20s %10s %10s %12s %12s %12s\n",
                    "Name", "RegHrs", "OT Hrs", "Reg Pay", "OT Pay", "Total Pay");
            System.out.println("---------------------------------------------------------------------------------");

            for (Worker w : hourlyWorkers) {
                w.displayWeeklyPay(hours);
            }

            System.out.println("\nSalaried Workers:\n");
            System.out.printf("%-20s %10s %12s\n", "Name", "Hours", "Weekly Pay");
            System.out.println("----------------------------------------------");

            for (SalaryWorker sw : salaryWorkers) {
                sw.displayWeeklyPay(hours);
            }
        }
    }
}
