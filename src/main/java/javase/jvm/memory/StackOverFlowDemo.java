package javase.jvm.memory;

import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2017/11/26 16:50
 */
public class StackOverFlowDemo {
    private int count = 0;

    private void recursion(long a,long b,long c, long d) {
        long e=0,f=0,g=0,h=0;
        count++;
        recursion(a,b,c,d);
    }

    private void test1(){
        {
            long a;
        }
        int b;
    }
    private void test2(){
        long a;
        int b;

    }

    @Test
    public void test() {
        try {
            recursion(0L,0L,0L,0L);
        } catch (Throwable e) {
            System.out.println("the deepth of stack is:" + count);
            e.printStackTrace();
        }
    }
}
