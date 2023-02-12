package by.itacademy.thread.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Storage {
    static Logger logger = LogManager.getLogger();
    private static final Storage instance = new Storage();
    private static final int MAX_COUNT_BOX = 500;
    private static final int MIN_COUNT_BOX = 50;
    private static final int COUNT_BROUGHT_BOX = 250;
    private static final int COUNT_TAKEN_AWAY_BOX = 250;
    private static final int COUNT_LOADING_BOX = 50;

    private static final int DEFAULT_COUNT_BOX = 300;
    private int countBox = DEFAULT_COUNT_BOX;
    private ReentrantLock locker = new ReentrantLock(true);
    private Condition condition = locker.newCondition();
    private ArrayDeque<Ramp> arrayDeque = new ArrayDeque<>();

    private Storage() {
    }

    public static Storage getInstance() {
        return instance;
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

    public synchronized int loading() {
        if (COUNT_LOADING_BOX < MIN_COUNT_BOX) {
            countBox += COUNT_BROUGHT_BOX;
            logger.log(Level.INFO, "Boxes are brought");
        }
        countBox -= COUNT_LOADING_BOX;
        return COUNT_LOADING_BOX;
    }

    public synchronized int unloading(int countBoxUnload) {
        if (countBoxUnload + countBoxUnload > MAX_COUNT_BOX) {
            countBox -= COUNT_TAKEN_AWAY_BOX;
            logger.log(Level.INFO, "Boxes are taken away");
        }
        countBox += countBoxUnload;
        countBoxUnload = 0;
        return countBoxUnload;
    }
}
