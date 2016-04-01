package concurrency;

/**
 * Created by lsy on 2016/3/29.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
