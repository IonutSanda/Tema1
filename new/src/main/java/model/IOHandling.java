package model;

import model.building.Hotel;
import org.apache.log4j.Logger;
import service.HotelService;

import java.io.*;

class IOHandling {

    private static Logger logger = Logger.getLogger(IOHandling.class);

    static void tryWithoutResources() {
        //Write the hotels into the HotelsIn.txt file
        FileReader in;
        FileWriter out = null;

        try {
            in = new FileReader("HotelsIn.txt");
            out = new FileWriter("HotelsOut.txt");

            int value;
            while ((value = in.read()) != -1) {
                out.write(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void tryWithResources(HotelService hotelService) {
        //Write using Try with Resources, the hotels into the HotelsOut.txt file
        try (FileWriter in = new FileWriter("HotelsIn.txt")) {
            for (Hotel hotel : hotelService.getHotels()) {
                in.write(String.valueOf(hotel) + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void hotelDeserialization(String fileName) {
        //Deserialization of hotels
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            objectInputStream.readObject();
            logger.debug("Deserialized");
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String hotelSerialization(HotelService hotelService) {
        //Serialization of hotels
        String fileName = "Hotels.hot";
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Hotel hotel : hotelService.getHotels()) {
                objectOutputStream.writeObject(hotel);
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("Serialized");
        return fileName;
    }
}
