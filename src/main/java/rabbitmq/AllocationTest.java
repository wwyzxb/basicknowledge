package rabbitmq;

/**
 * @Author Vincent
 * @Date 2017/12/6 22:44
 * <p>
 * GC args: -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class AllocationTest {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1 = new byte[50 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[2 * _1MB];
        byte[] allocation5 = new byte[2 * _1MB];
        byte[] allocation6 = new byte[2 * _1MB];
        byte[] allocation7 = new byte[5 * _1MB];
        byte[] allocation8 = new byte[5 * _1MB];
        byte[] allocation9 = new byte[5 * _1MB];
        byte[] allocation10 = new byte[5 * _1MB];
        byte[] allocation11 = new byte[5 * _1MB];
//        allocation3 =null;
//        allocation4 =null;
        //[GC (Allocation Failure) [DefNew: 4777K->4777K(9216K), 0.0000305 secs][Tenured: 6144K->4772K(10240K), 0.0050529 secs] 10921K->4772K(19456K)
        //为什么新生代allocation4 =null新生代的内存使用情况没有下降，而老年代则下降了
        byte[] allocation12 = new byte[20 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
