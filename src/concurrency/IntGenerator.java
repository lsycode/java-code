package concurrency;

/**
 * Created by lsy on 2016/3/29.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
