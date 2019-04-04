package persons;



/**
 * Created by Ionut on 3/31/2019.
 */
public class Employee extends Client{

    private String employeeNumber;

    public Employee(String employeeNumber, String personName, String personEmail, int personAge, char personSex) {
        super(personName,personEmail,personAge,personSex);
        this.employeeNumber = employeeNumber;
    }

}
