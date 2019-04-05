package persons;

public class Person {
    private String name;
    private int age;
    private char sex;

    public Person (String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private String personSexCheck(){
        if (sex == 'M') {
            return "Male";
        } else {
            return "Female";
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return personSexCheck();
    }
}
