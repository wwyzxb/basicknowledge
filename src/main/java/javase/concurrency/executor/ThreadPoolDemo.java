package javase.concurrency.executor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newCachedThreadPool()线程池示例
 *
 * @Author Vincent
 * @Date 2017/11/25 19:13
 */
public class ThreadPoolDemo {

    /**
     * demo1中线程池中的三个线程分别执行task1、2、3
     */
    private void demo1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int taskNo = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "------->task:" + taskNo);
                }
            });
        }
    }

    /**
     * demo2中线程池中的只有第1个线程执行task1、2、3
     */
    private void demo2() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int taskNo = i;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "------->task:" + taskNo);
                }
            });
        }
    }

    @Test
    public void test() {
        demo1();
        demo2();
    }

}
