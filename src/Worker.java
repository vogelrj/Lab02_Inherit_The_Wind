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

    /**
     * Obtains the worker object;s hourly pay rate.
     *
     * @return the hourly pay rate double
     */

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    /**
     * Sets a new hourly pay rate for the object
     *
     * @param hourlyPayRate double
     */

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }


    /**
     * Calculates the weekly pay from an hours worked double
     * for any hours over 40 at time-and-a-half (1.5 * hourlyPayRate).
     * Under 40hrs is straight pay
     *
     * @param hoursWorked double the total hours that week
     * @return the total pay for the period double
     */

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


    /**
     * Displays the weekly pay breakdown, showing regular/overtime (if applicable) hours and pay as well as total pay
     *
     * @param hoursWorked double the total hours that week
     */

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = (hoursWorked > 40) ? (hoursWorked - 40) : 0.0;
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        String otPayColumn = (overtimeHours > 0)
                ? String.format("%.2f", overtimePay)
                : "No OT";

        System.out.printf("%-20s %10.2f %10.2f %12.2f %12s %12.2f\n",
                formalName(),        // Worker name, e.g. "Mr. John Smith"
                regularHours,        // e.g. 40.00
                overtimeHours,       // e.g. 10.00 or 0.00
                regularPay,          // e.g. 800.00
                otPayColumn,         // e.g. "150.00" or "No OT"
                totalPay);           // e.g. 950.00 or 800.00
    }

    /**
     * Produces a JSON representation of the person object.
     *
     * @return Worker object in JSON format.
     */

    @Override
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"hourlyPayRate\":%.2f}",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), hourlyPayRate);
    }

    /**
     * Produces a XML representation of the person object.
     *
     * @return Worker object in XML format.
     */

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

    /**
     * Produces a CSV representation of the person object.
     *
     * @return Worker object in CSV format.
     */

    @Override
    public String toCSV() {
        return super.toCSV() + String.format(", %.2f", hourlyPayRate);
    }

    /**
     * Produces a String representation of the person object.
     *
     * @return Worker object in String.
     */

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
