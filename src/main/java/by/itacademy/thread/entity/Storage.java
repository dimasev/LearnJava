package by.itacademy.thread.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Storage {
    static Logger logger = LogManager.getLogger();
    private static final int MAX_COUNT_BOX = 500;
    private static final  int MIN_COUNT_BOX = 50;
    private static final  int DELTA_BOX =250;
    private static final  int COUNT_LOADING_BOX = 50;

    private  AtomicInteger countBox = new AtomicInteger(250);
    private ReentrantLock locker = new ReentrantLock(true);
    private Condition condition = locker.newCondition();
    private ArrayDeque<Ramp> arrayDeque = new ArrayDeque<>();

    private Storage() {
    }

    private static class StorageHolder{
        public static final Storage HOLDER_INSTANCE = new Storage();
    }
    public static Storage getInstance() {
        return StorageHolder.HOLDER_INSTANCE;
    }

    public void setArrayDeque(ArrayDeque<Ramp> arrayDeque) {
        this.arrayDeque = arrayDeque;
    }

    public Ramp getRamp() {

        locker.lock();
        Ramp ramp;
        while ((ramp = this.arrayDeque.poll()) == null) {
            condition.awaitUninterruptibly();
        }
        locker.unlock();
        return ramp;
    }

    public void releaseRamp(Ramp ramp) {
        locker.lock();
        arrayDeque.add(ramp);
        condition.signal();
        locker.unlock();
    }

    public int loading() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if ( countBox.get()< MIN_COUNT_BOX) {
            countBox.addAndGet(DELTA_BOX);
            logger.log(Level.INFO, "Boxes are brought");
        }
        countBox.addAndGet(-COUNT_LOADING_BOX);
        return COUNT_LOADING_BOX;
    }

    public int unloading(int countBoxUnload) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if ( countBox.get() > MAX_COUNT_BOX) {
            System.out.println(countBox.get());
            countBox.addAndGet(-DELTA_BOX);
            logger.log(Level.INFO, "Boxes are taken away");
        }
        countBox.addAndGet(countBoxUnload);
        return 0;
    }
}
