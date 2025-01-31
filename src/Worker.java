public class Worker extends Person {

    private double hourlyPayRate;

    /**
     * Inherits and instantiates Person Class and adds hourlyPayRate attribute.
     *
     * @param hourlyPayRate the worker's hourly pay rate
     */
    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked){
        double overtimeRate = hourlyPayRate * 1.5;
        double paycheck = 0.0;
        double overtimePay = 0.0;
        if (hoursWorked <= 40){
            paycheck = hoursWorked * hourlyPayRate;
        } else{
            double overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * overtimeRate;
            paycheck = 40 * hourlyPayRate + overtimePay;
        }
        return paycheck;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = (hoursWorked > 40) ? hoursWorked - 40 : 0.0;
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("%s %s (%s) worked %.2f hours this week.%n",
                getTitle(), getFirstName(), getID(), hoursWorked);
        System.out.printf("  Regular Hours: %.2f => $%.2f%n", regularHours, regularPay);
        System.out.printf("  Overtime Hours: %.2f => $%.2f%n", overtimeHours, overtimePay);
        System.out.printf("  Total Pay: $%.2f%n", totalPay);
    }

}
