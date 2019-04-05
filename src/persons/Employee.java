package persons;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Employee extends Person{

    private final String employeeNumber;

    public Employee(String name, String employeeNumber, int age, char sex) {
        super(name, age, sex);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString(){
        return "Employee Name: " + getName() + ", Employee Nr: " + employeeNumber + ", Age: " + getAge() + ", Gender: " + getSex();
    }

}
