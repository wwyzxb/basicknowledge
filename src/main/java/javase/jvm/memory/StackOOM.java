package javase.jvm.memory;

public class StackOOM {
    private int stackLength = 1;

    private void dontStop() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception err) {
            }
        }
    }

    /**
     * 无限循环中不停的生成线程，而每一个线程需要一定的栈空间，
     * 最终导致需要申请的栈空间得不到满足，从而造成OutOfMemoryError
     */
    public void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            t.start();
            stackLength++;
        }
    }

    public static void main(String[] args) throws Throwable {
        StackOOM oom = new StackOOM();
        try {
            oom.stackLeakByThread();
        } catch (Throwable err) {
            System.out.println("Stack length:" + oom.stackLength);
            throw err;
        }
    }
}