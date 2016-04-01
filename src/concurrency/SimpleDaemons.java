package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by lsy on 2016/3/28.
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main( String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.printf(" all daemons started");
        TimeUnit.MILLISECONDS.sleep(68);
    }
}
