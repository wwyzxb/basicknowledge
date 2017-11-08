package javase.finaltest;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Vincent
 * @Date 2017/11/9 0:55
 */
class Value {
    int i;

    Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    /**
     * 编译时数值，编译时可以直接进行运算；
     * 定义成static表示只有一份，定义成final表示为一个常量；
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;

    private final int test=0;

    /**
     * 下面两个数虽然被定义成final，但是编译时并不知道其值，只有在运行时才能获得其值
     */
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);

    private Value v1 = new Value(11);

    /**
     * 对象定义成final意味着v2不能在指向其它对象，但是对象的值可以改变
     */
    private final Value v2 = new Value(22);
    private static final Value v3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
    public String toString() {
        return id + ": " + "i4=" + i4 + ",INT_5=" + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //fd1.valueOne=10;//改变final常量的值编译时不通过
        fd1.v2.i++;
        //fd1.v2=new Value(1);//v2不能再指向其它对象
        fd1.v1 = new Value(9);
        //fd1.a=new int[]{1,2};//数组应用不能在指向其它数组对象，但是对象的值可以改变
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;//数组中的数据
        }
        System.out.println(Arrays.toString(fd1.a));
        System.out.println(fd1);
    }
}
