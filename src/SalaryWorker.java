public class SalaryWorker extends Worker {

    double annualSalary;


    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double annualSalary) {
        super(ID, firstName, lastName, title, YOB, 0.0);
        this.annualSalary = annualSalary;
    }

    /**
     * Obtains the worker object's annual pay rate.
     *
     * @return the hourly pay rate double
     */

    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Sets a new annual pay rate for the object
     *
     * @param annualSalary double
     */

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    /**
     * Calculates the weekly pay from salaried pay divided by 52 weeks
     *
     * @param hoursWorked double the total hours that week. Not used in function
     * @return the total pay for the period double
     */

    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    /**
     * Displays the weekly pay breakdown, showing salaried pay broken down into a single week
     *
     * @param hoursWorked double the total hours that week. Not used in function
     */

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);

        System.out.printf("%-20s %10.2f %12.2f\n",
                formalName(),
                hoursWorked,
                weeklyPay);
    }

    @Override
    public String toString() {
        return String.format("SalaryWorker{ID='%s', name='%s %s', title='%s', YOB=%d, annualSalary=%.2f}",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }

    /**
     * Produces a CSV representation of the person object.
     *
     * @return SalaryWorker object in CSV format.
     */

    @Override
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %d, %.2f",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }

    /**
     * Produces a JSON representation of the person object.
     *
     * @return SalaryWorker object in JSON format.
     */

    @Override
    public String toJSON() {
        return String.format(
                "{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"annualSalary\":%.2f}",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }

    /**
     * Produces an XML representation of the person object.
     *
     * @return SalaryWorker object in XML format.
     */

    @Override
    public String toXML() {
        return String.format("<SalaryWorker>" +
                        "<ID>%s</ID>" +
                        "<firstName>%s</firstName>" +
                        "<lastName>%s</lastName>" +
                        "<title>%s</title>" +
                        "<YOB>%d</YOB>" +
                        "<annualSalary>%.2f</annualSalary>" +
                        "</SalaryWorker>",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }
}



