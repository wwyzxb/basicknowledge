package javase.jvm.classloder;

/**
 * @Author Vincent
 * @Date 2017/12/28 0:09
 */
public class InitialTest {
    static class DeadLoopClass {
        /**
         * 在多线程中该初始化只会执行一次
         */
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
