package handling.thread;

import model.person.Person;
import repository.PersonRepository;

import java.util.List;

public class ClientThread {

    private List<Person> persons;
    private final PersonRepository personService;

    public ClientThread(List<Person> personList, PersonRepository personService) {
        this.persons = personList;
        this.personService = personService;
    }

    public void startThreads() {
        new Thread(() -> persons.forEach(person -> {
            //                Thread.sleep(1000);
            synchronized (personService) {
                personService.listClients();
            }
        })
        ).start();
    }


}
