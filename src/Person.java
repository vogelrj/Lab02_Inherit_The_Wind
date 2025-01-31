import java.util.Calendar;

public class Person
{
    private String firstName;
    private String lastName;
    private String ID;    // static value
    private String title;
    private int YOB;      // 1940 - 2000

    public Person(String ID, String firstName, String lastName, String title, int YOB)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Returns the first name of the person obj
     *
     * @return firstName as str value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName Value
     *
     * @param firstName str value
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the person obj
     *
     * @return lastName as str value.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName Value
     *
     * @param lastName str value
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the ID of the person obj
     *
     * @return ID as str value.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the title of the person obj
     *
     * @return title as str value.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title Value
     *
     * @param title str value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the YOB of the person obj
     *
     * @return YOB as int value.
     */
    public int getYOB() {
        return YOB;
    }

    /**
     * Sets the YOB Value
     *
     * @param YOB str value
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    /**
     * Returns the full name of the person obj
     *
     * @return first and last names as strings separated by a space.
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Return the person age relative to the current year (2025).
     *
     * @return int value of age.
     */
    public String getAge() {
        int currentYear = 2025;
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Returns the person's age for given year.
     *
     * @param year reference year for calculated age.
     * @return The age of the person during the year param.
     */
    public String getAge(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        int calendarYear = cal.get(Calendar.YEAR);

        int age = calendarYear - YOB;
        return String.valueOf(age);
    }

    /**
     * Produces a string representation of the object.
     *
     * @return Person object as a string.
     */
    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Produces a CSV representation of the person object.
     *
     * @return Person object as a CSV format.
     */
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %d",
                ID, firstName, lastName, title, YOB);
    }

    /**
     * Produces a JSON-formatted string of the person obj.
     *
     * @return Person object in JSON format.
     */
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

    /**
     * Produces an XML-formatted string of the person obj.
     *
     * @return Person object in XML format.
     */
    public String toXML() {
        return String.format("<Person>" +
                        "<ID>%s</ID>" +
                        "<firstName>%s</firstName>" +
                        "<lastName>%s</lastName>" +
                        "<title>%s</title>" +
                        "<YOB>%d</YOB>" +
                        "</Person>",
                ID, firstName, lastName, title, YOB);
    }

}
