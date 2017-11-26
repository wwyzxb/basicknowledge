package javase.option;

import org.junit.Test;

/**
 * 计算机中所有的数都是通过补码的方式进行存储的,而位运算都是通过补码（32位数）在计算机中进行存储和计算的
 * 正数：原码=反码=补码
 * eg:[+1] = [0000 0000 0000 0001]原 = [0000 0000 0000 0001]反 = [0000 0000 0000 0001]补
 * 负数：原码（符号位为1，其它与正数相同），反码（符号位1不变，其它位取反），补码（反码+1）
 * eg:[-1] = [1000 0000 0000 0001]原 = [1111 1111 1111 1110]反 = [1111 1111 1111 1111]补
 *
 * @Author Vincent
 * @Date 2017/11/26 9:13
 */
public class BitOperation {
    /**
     * 按位或操作:将数组转换成二进制，每一位进行或操作
     * 6:0110
     * 9:1001
     * -------
     * 15:1111
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo1(int num1, int num2) {
        return num1 | num2;
    }

    /**
     * 按位与操作：将数组转换成二进制，每一位进行与操作
     * 6:0110
     * 9:1001
     * -------
     * 0:0000
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo2(int num1, int num2) {
        return num1 & num2;
    }

    /**
     * 按位非操作：
     * 6:0000 0000 0000 0110
     * -------
     * -7:1111 1111 1111 1001(按位取反)
     *
     * @param num1
     * @return
     */
    private static int demo3(int num1) {
        return ~num1;
    }

    /**
     * 按位异或操作：补码计算位相同取0，位不同取1
     * -6：1111 1111 1111 1010
     * 9：0000 0000 0000 1001
     * -----------------------
     * -13:1111 1111 1111 0011
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo4(int num1, int num2) {
        return num1 ^ num2;
    }

    /**
     * 左位移操作:num1的补码向左移动num2位
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo5(int num1, int num2) {
        return num1 << num2;
    }

    /**
     * 右位移操作：num1的补码向右移动num2位（空位按原来的符号填充）
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo6(int num1, int num2) {
        return num1 >> num2;
    }

    /**
     * 无符号右位移操作：num1的补码向右移动num2位（空位按0填充）
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int demo7(int num1, int num2) {
        return num1 >>> num2;
    }


    @Test
    public void test() {
        System.out.println(demo1(-6, 9));
        System.out.println(demo2(6, 9));
        System.out.println(demo3(6));
        System.out.println(demo4(-6, 9));
        System.out.println(demo5(9, 2));
    }
}
