package javase.jvm.memory;

/**
 * @Author Vincent
 * @Date 2017/12/7 0:44
 */
public class AllocationTest3 {
    private static final int _1MB = 1024 * 1024;

    /**
     * GC args: -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     */
    public static void testTenuringThreadHold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args){
        testTenuringThreadHold();
    }
}
