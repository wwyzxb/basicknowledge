package javase.concurrency.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用Executors.newSingleThreadScheduledExecutor()来模拟HeartBeat
 * <p>
 * 并示例表示scheduleWithFixedDelay和scheduleAtFixedRate方法的区别
 *
 * @Author Vincent
 * @Date 2017/11/25 18:05
 */
public class HeartBeat {
    Logger logger = LoggerFactory.getLogger(HeartBeat.class);
    ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    private void heartBeat() {
        threadLocal.set(threadLocal.get() + 1);
        try {
            TimeUnit.SECONDS.sleep(10);
            logger.info(Thread.currentThread().getName() + " Heartbeat--------------------->" + threadLocal.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void demo1() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        /**
         * initialDelay:启动任务之后，延迟多少秒执行
         * delay:前一个任务执行完之后，延迟多少秒执行
         */
        executor.scheduleWithFixedDelay(this::heartBeat, 0, 5L, TimeUnit.SECONDS);
    }

    private void demo2() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        /**
         * initialDelay:启动任务之后，延迟多少秒执行
         * period:前一个任务开始执行之后，延迟多少秒执行（会等待前一个任务完成之后再执行）
         */
        executor.scheduleAtFixedRate(this::heartBeat, 0, 5L, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new HeartBeat().demo1();
        new HeartBeat().demo2();
    }
}
