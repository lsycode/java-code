package concurrency;

/**
 * Created by lsy on 2016/3/28.
 */
public class BasicThreads {
    public static void main( String[] args){
        for (int i=0;i<10;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting");
    }
}
