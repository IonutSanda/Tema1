package persons;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Client extends PersonList {

    private String personName;
    private String personEmail;
    private int personAge;
    private char personSex;

    public Client(String personName, String personEmail, int personAge, char personSex) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
        this.personSex = personSex;
    }

    private String personSexCheck(){
        if (personSex == 'M') {
             return "Male";
        } else {
            return "Female";
        }
    }


    @Override
    public String toString(){
        return "Name: " + personName + ", E-mail: " + personEmail + ", Age: " + personAge + ", Gender: " + personSexCheck();
    }
}

