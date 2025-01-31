public class SalaryWorker extends Worker {

    double annualSalary;


    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary(double hoursWorked) {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double calculateWeeklyPay() {
        return annualSalary / 52;
    }


    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("%s %s (%s) is a salary worker.%n",
                getTitle(), getFirstName(), getID());
        System.out.printf("  Hours Worked (ignored for pay calc): %.2f%n", hoursWorked);
        System.out.printf("  Weekly Pay (annualSalary / 52): $%.2f%n", weeklyPay);
    }

    @Override
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %d, %.2f",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"annualSalary\":%.2f}",
                getID(), getFirstName(), getLastName(), getTitle(), getYOB(), annualSalary);
    }

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

