package models.persons;

public class Person{

    private String clientName;
    private String employeeName;
    private int clientAge;
    private int employeeAge;
    private String clientEmail;
    private String employeeEmail;
    private static String employeeNumber;

    public Person(String clientName, int clientAge, String clientEmail) {
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientEmail = clientEmail;
    }

    public Person(String employeeName, String employeeEmail, int employeeAge, String employeeNumber) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        Person.employeeNumber = employeeNumber;
    }

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

    public String getEmployeeNumer() {
        return employeeNumber;
    }

    public void setEmployeeNumer(String employeeNumer) {
        Person.employeeNumber = employeeNumer;
    }

    public String getClientDetails(){
        return "Name: " + clientName + ", Age: " + clientAge + ", E-mail: " + clientEmail;
    }

    public String getEmployeeDetails(){
        return "Name: " + employeeName + ", E-mail: " + employeeEmail + ", Age: " + employeeAge + ", Employee Nr: " + employeeNumber;
    }
}
