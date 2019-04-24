package models.persons;

public class Person{

    private String clientName;
    private String employeeName;
    private int clientAge;
    private int employeeAge;
    private String clientEmail;
    private String employeeEmail;
    private static String employeeNumber;
    private Gender gender;

    public Person(String clientName, int clientAge, String clientEmail, Gender gender) {
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientEmail = clientEmail;
        this.gender = gender;
    }

    public Person(String employeeName, String employeeEmail, int employeeAge, String employeeNumber, Gender gender) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        Person.employeeNumber = employeeNumber;
        this.gender = gender;
    }

    public Gender getGender(){
        return gender;
    }

    @Deprecated
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        Person.employeeNumber = employeeNumber;
    }

    @SuppressWarnings("deprecation")
    public String getClientDetails(){
        return "Name: " + getClientName() + ", Age: " + clientAge + ", E-mail: " + clientEmail;
    }

    public String getEmployeeDetails(){
        return "Name: " + employeeName + ", E-mail: " + employeeEmail + ", Age: " + employeeAge + ", Employee Nr: " + employeeNumber;
    }
}
