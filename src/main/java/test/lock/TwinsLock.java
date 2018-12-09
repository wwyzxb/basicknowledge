package test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {
    //设置状态的初始值
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedLongSynchronizer {
        public Sync(long count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        @Override
        protected long tryAcquireShared(long reduceCount) {
            //通过CAS来获取状态值
            for (; ; ) {
                long current = getState();
                long newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }


        @Override
        protected boolean tryReleaseShared(long returnCount) {
            //通过CAS来释放状态值
            for (; ; ) {
                long current = getState();
                long newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        //加锁
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        //解锁
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
