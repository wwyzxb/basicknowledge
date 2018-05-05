package javase.concurrency.executor.guava;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/28
 **/
public class ExecutorInGuava {
    private final ListeningExecutorService executor = MoreExecutors
            .listeningDecorator(Executors.newCachedThreadPool(daemonThreadsNamed("execution-client-%d")));

    public static ThreadFactory daemonThreadsNamed(String nameFormat) {
        return new ThreadFactoryBuilder().setNameFormat(nameFormat).setDaemon(true).build();
    }

    public void runExecution() {
        Excution excution = new Excution();
        ListenableFuture<Object> result = executor.submit(excution);

        Futures.addCallback(result, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
