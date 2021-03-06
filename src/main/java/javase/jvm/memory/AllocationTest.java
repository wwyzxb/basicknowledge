package javase.jvm.memory;

import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2017/12/6 22:44
 *
 */
public class AllocationTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * GC args: -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation1() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args){
        testAllocation1();
    }
}
