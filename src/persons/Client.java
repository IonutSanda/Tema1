package persons;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Client {

    private String personName;
    private String personEmail;
    private int personAge;
    private char personSex;
    private String personSexCheck;

    public Client(String personName, String personEmail, int personAge, char personSex) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
        this.personSex = personSex;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public int getPersonAge() {
        return personAge;
    }

    public char getPersonSex() {
        return personSex;
    }

//    public String getPersonSexCheck() {
//        return personSexCheck;
//    }

    private String personSexCheck(){
        if (personSex == 'M') {
             personSexCheck = "Male";
        } else {
            personSexCheck = "Female";
        }
        return "Invalid gender";
    }

    @Override
    public String toString() {
        return "Name: " + personName + ", E-mail: " + personEmail + ", Age: " + personAge + ", Sex: " + personSexCheck();
    }
}

