package javase.concurrency.demo;

/**
 * @Author Vincent
 * @Date 2017/11/23 23:26
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<String> strThreadLocal = new ThreadLocal<String>() {
        //对strThreadLocal进行初始化
        @Override
        protected String initialValue() {
            return "initialization...";
        }
    };

    private static void testThreadLocal() {
        //thread:t0使用strThreadLocal存储自己的值
        Thread t0 = new Thread() {
            @Override
            public void run() {
                super.run();
                strThreadLocal.set("this is t0");
                System.out.println(Thread.currentThread().getName() + ":" + strThreadLocal.get());
            }
        };
        //thread:t1使用strThreadLocal存储自己的值
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                strThreadLocal.set("this is t1");
                System.out.println(Thread.currentThread().getName() + ":" + strThreadLocal.get());
            }
        };
        //thread:t2使用strThreadLocal存储自己的值
        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                strThreadLocal.set("this is t2");
                System.out.println(Thread.currentThread().getName() + ":" + strThreadLocal.get());
            }
        };
        t0.start();
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + ":" + strThreadLocal.get());
    }


    public static void main(String[] args) {
        testThreadLocal();
    }

}


