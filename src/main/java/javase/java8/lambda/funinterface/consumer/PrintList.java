package javase.java8.lambda.funinterface.consumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author Vincent
 * @Date 2018/1/21 17:48
 */
public class PrintList {
    /**
     * 逻辑处理函数
     *
     * @param list
     * @param consumer
     */
    public void forEach(List<Integer> list, Consumer<Integer> consumer) {
        for (Integer i : list) {
            /**accpet的具体的实现交给Lambda表达式的主体去实现*/
            consumer.accept(i);
        }
    }

    @Test
    public void testPrintList() {
        /**
         * Lambda表达式结构
         * Integer i:accept函数的参数
         * System.out.println(i):accept函数的方法主体
         */
        forEach(Arrays.asList(1, 2, 3, 5, 6), (Integer i) -> System.out.println(i));
    }
}
