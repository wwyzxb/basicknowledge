package javase.jvm.memory;

import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2017/12/7 0:41
 */
public class AllocationTest2 {
    private static final int _1MB = 1024 * 1024;
    /**
     * GC args: -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    @Test
    public void testAllocation2() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
