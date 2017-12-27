package javase.jvm;

import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2017/11/26 18:00
 */
public class GCDemo {
    private void gcDemo() {
        byte[] b1 = new byte[1024 * 1024 / 2];
        byte[] b2 = new byte[1024 * 1024 * 8];
        b2 = null;
        b2 = new byte[1024 * 1024 * 8];
        //System.gc();
    }

    @Test
    public void test() {
        for(int i=0;i<Integer.MAX_VALUE;i++){
            String t=String.valueOf(i).intern();
        }
    }
}
