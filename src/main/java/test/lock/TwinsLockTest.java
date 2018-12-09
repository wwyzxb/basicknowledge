package test.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    @Test
    public void test() throws InterruptedException {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i=0;i<10;i++){
            Worker worker=new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
