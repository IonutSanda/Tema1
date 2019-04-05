package persons;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Client extends Person{

    private String personEmail;

    public Client(String name, String personEmail, int age, char sex) {
        super(name, age, sex);
        this.personEmail = personEmail;
    }
    @Override
    public String toString(){
        return "Client Name: " + getName() + ", Email: " + personEmail + ", Age: " + getAge() + ", Gender: " + getSex();
    }
}

