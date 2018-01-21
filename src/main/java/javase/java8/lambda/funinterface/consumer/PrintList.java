package javase.java8.lambda.funinterface.consumer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author Vincent
 * @Date 2018/1/21 17:48
 */
public class PrintList {
    private static List<Integer> list=new ArrayList<>();
    static {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }
    public void print( Consumer<List<Integer>> consumer) {
        consumer.accept(list);
    }
    @Test
    public void testPrintList(){
        print((List<Integer> list)->{
            for(Integer i:list){
                System.out.println(i);
            }
        });
    }

    /**
     * 逻辑处理函数，accpet的具体的实现交给Lambda表达式的主体去实现
     * @param list
     * @param consumer
     */
    public void forEach(List<Integer> list,Consumer<Integer> consumer){
        for(Integer i:list){
            consumer.accept(i);
        }

    }

    @Test
    public void testPrintList1(){
        /**
         * Lambda表达式结构
         * Integer i:accept函数的参数
         * System.out.println(i):accept函数的方法主体
         */
        forEach(Arrays.asList(1,2,3,5,6),(Integer i)->System.out.println(i));
    }




}
