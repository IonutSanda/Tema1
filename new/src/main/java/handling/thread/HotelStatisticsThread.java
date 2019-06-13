package handling.thread;

public class HotelStatisticsThread extends Thread {

    public static String getFullStatistics() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread responsible for this job is: " + Thread.currentThread().getName()/* + " " + getCheckInStatistics()*/;
    }


}


