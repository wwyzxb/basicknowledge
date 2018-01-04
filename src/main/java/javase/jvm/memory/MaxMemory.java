package javase.jvm.memory;

import java.util.Vector;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/4
 **/
public class MaxMemory {
    private static  final int _1MB=1024*1024;

    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 1; i <= 10; i++) {
            byte[] b=new byte[_1MB];
            v.add(b);
            System.out.println(i+"M is allocated!");
        }
        System.out.println("Max memory:"+Runtime.getRuntime().maxMemory());
    }
}
