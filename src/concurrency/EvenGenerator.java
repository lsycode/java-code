package concurrency;

/**
 * Created by lsy on 2016/3/29.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
