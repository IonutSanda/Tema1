package model.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enumeration.Gender;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {

    private String clientName, employeeName;
    private int clientAge, employeeAge;
    private String clientEmail, employeeEmail;
    private String employeeNumber;
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
        this.employeeNumber = employeeNumber;
        this.gender = gender;
    }

    @SuppressWarnings("deprecation")
    public String getClientDetails() {
        return "Name: " + getClientName() + ", Age: " + clientAge + ", E-mail: " + clientEmail;
    }

    public String getEmployeeDetails() {
        return "Name: " + employeeName + ", E-mail: " + employeeEmail + ", Age: " + employeeAge + ", Employee Nr: " + employeeNumber;
    }

}
