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

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
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

        System.out.printf("%s %s %s%n",
                getTitle(), getFirstName(), getLastName());
        System.out.printf("  Regular Hours: %.2f%n", regularHours);
        System.out.printf("  Regular Pay: $%.2f%n", regularPay);

        if (overtimeHours > 0) {
            System.out.printf("  Overtime Hours: %.2f%n", overtimeHours);
            System.out.printf("  Overtime Pay: $%.2f%n", overtimePay);
        } else{
            System.out.println("  No Overtime Pay This Period");
        }

        System.out.printf("  Total Pay: $%.2f%n", totalPay);
    }

    @Override
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"hourlyPayRate\":%.2f}",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), hourlyPayRate);
    }

    @Override
    public String toXML() {
        return String.format("<Worker>" +
                        "<ID>%s</ID>" +
                        "<firstName>%s</firstName>" +
                        "<lastName>%s</lastName>" +
                        "<title>%s</title>" +
                        "<YOB>%d</YOB>" +
                        "<hourlyPayRate>%.2f</hourlyPayRate>" +
                        "</Worker>",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), hourlyPayRate);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + String.format(", %.2f", hourlyPayRate);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "ID='" + getID() + '\'' +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", YOB=" + getYOB() +
                ", hourlyPayRate=" + hourlyPayRate +
                '}';
    }

}
