package handling.thread;

import model.enumeration.Gender;
import model.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.PersonRepository;

import java.util.List;

public class HotelStatisticsThread extends Thread {

    private static Logger logger = LogManager.getLogger(HotelStatisticsThread.class);

    private static String name;

    private final PersonRepository personRepository;

    private static Person client1 = new Person("Sanda Ionut", 23, "ionut@sanda.me", Gender.MALE);


    public HotelStatisticsThread(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private static String getLocalName() {
        return name;
    }

    private static String getCheckInStatistics() {
        return "Client " + client1.getClientName() + " has checked in at: " + CheckInData.getTime() + " on " + CheckInData.getDate();
    }

    public static String getFullStatistics() {
        return "Thread responsible for this job is: " + Thread.currentThread().getName() + " " + getCheckInStatistics();
    }

    public void getStatistics() {
        new Thread(() -> {
            int counter = 1;
            while (counter < 20) {
                try {
                    synchronized (personRepository) {
                        personRepository.listClients().forEach(person -> {
                            if (personRepository.listClients().size() >= 0) {
//                                logger.info("Person Stats:" + CheckInData.getDateAndTime() + " " + Thread.currentThread().getName());
                                logger.info("Person Stats:" + getFullStatistics());
                            }
                        });
                    }
                    Thread.sleep(5000);
                    counter--;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    }


