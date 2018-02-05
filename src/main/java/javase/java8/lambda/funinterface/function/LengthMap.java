package javase.java8.lambda.funinterface.function;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * @Author Vincent
 * @Date 2018/1/21 18:15
 */
public class LengthMap {
    private static final List<String> initialList=Arrays.asList("Apple","Pear","Banana");

    /**处理具体逻辑的代码，用于计算List中每个元素的长度，接收一个List并返回一个Map*/
    public Map<String, Integer> getStrMap(List<String> list, Function<String, Integer> function) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : list) {
            /**apply()方法的逻辑运行时动态实现*/
            result.put(s, function.apply(s));
        }
        return result;
    }

    @Test
    public void testGetStrMap(){
        Map<String, Integer> resultMap=getStrMap(initialList,(String s)->s.length());
        System.out.println(resultMap);
    }

    @Test
    public void testGetStrMap1(){
        /**我们也可以使用匿名类来实现业务逻辑*/
        Function fun=new Function<List<String>,Map<String, Integer>>() {
            @Override
            public Map<String, Integer> apply(List<String> list) {
                Map<String, Integer> result = new HashMap<>();
                for (String s : list) {
                    result.put(s, s.length());
                }
                return result;
            }
        };
        Map<String, Integer> resultMap= (Map<String, Integer>) fun.apply(initialList);
        System.out.println(resultMap);
    }
}
