package service;

import handling.thread.CheckInData;
import handling.thread.HotelStatisticsThread;
import model.ValidationException;
import model.building.Hotel;
import model.enumeration.ErrorCodes;
import model.person.Person;
import model.person.RandomNumberGenerator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import repository.HotelRepository;

import java.util.*;

public class HotelService {
    private static Logger logger = LogManager.getLogger(HotelRepository.class);

    private HotelRepository hotelRepository;
    private final Map<Hotel, List<Person>> checkinList = new HashMap<>();

    public HotelService(HotelRepository hotelRepository) {

        this.hotelRepository = hotelRepository;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 10;
                while (counter >=0) {
                    synchronized (checkinList) {
                        if (checkinList.size() > 0) {
                            counter = 3;
                        } else {
                            counter--;
                        }
                        for (Map.Entry<Hotel, List<Person>> entry : checkinList.entrySet()) {
                            logger.info("Hotel Statistics: " + entry.getKey());
                            logger.info(" Person Statistics: " + Arrays.toString(entry.getValue().toArray()) + /*HotelStatisticsThread.getCheckInStatistics() +*/ HotelStatisticsThread.getFullStatistics());
                        }

                        checkinList.clear();
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }).start();
    }

    @SuppressWarnings("deprecation")
    public String validateAndAdd(Hotel hotel) throws ValidationException {
        if (hotel.getRating() < 0) {
            throw new ValidationException("Rating must be positive", ErrorCodes.RATING_NEGATIVE);
        }
        if (hotel.getHotelName().equals("")) {
            return "Please enter a Hotel name";
        }
        if (hotel.getName().length() < 1) {
            return "Please enter a Hotel name";
        }
        if (hotel.getCapacity() < 100) {
            return "Hotel capacity under 100";
        }
        if (hotel.getRating() < 2.5) {
            return "Rating is too low";
        }

        try {
            validateAndAdd(null);
        } catch (NullPointerException e) {
            logger.debug("Hotel Name can not be NULL - class: HotelService; ln-37");
        }


        hotelRepository.add(hotel);
        return "Hotel has been added";
    }

    public List<Hotel> getHotels() {
        return hotelRepository.listHotels();
    }


    public void checkIn(Person client, Hotel hotel) {
        synchronized (checkinList) {
            try {
                Thread.sleep(3000);
                logger.info("Checked in person: " + client + " at: " + CheckInData.getDateAndTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!checkinList.containsKey(hotel)) {
                checkinList.put(hotel, new LinkedList<>());
            }

            checkinList.get(hotel).add(client);
        }
    }

    public Hotel getRandomHotel() {
        return getHotels().get(RandomNumberGenerator.randomHotelAssignment(0,3));
    }
}

