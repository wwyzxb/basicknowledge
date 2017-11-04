package javase.object;

/**
 * @Author Vincent
 * @Date 2017/11/4 14:23
 */
public class ThisTest {
    private int i;
    private static ThisTest instance;

    private ThisTest increament() {
        i++;
        //这里的this关键字返回了对当前对象的引用
        return this;
    }

    /**
     * 线程不安全的单例模式
     *
     * @return
     */
    private static ThisTest creatObject() {
        if (instance == null) {
            instance = new ThisTest();
        }
        return instance;
    }

    public static void main(String[] args) {
        //3
        System.out.println(creatObject().increament().increament().increament().i);
    }
}
