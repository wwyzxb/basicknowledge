package javase.java8.lambda.funinterface.function;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * @Author Vincent
 * @Date 2018/1/21 18:15
 */
public class LengthMap {
    public Map<String, Integer> getStrMap(List<String> list, Function<String, Integer> function) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : list) {
            result.put(s, function.apply(s));
        }
        return result;
    }

    @Test
    public void testGetStrMap(){
        System.out.println(getStrMap(Arrays.asList("Apple","Pear","Banana"),(String s)->s.length()));
    }

    @Test
    public void testGetStrMap1(){
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
        System.out.println(fun.apply(Arrays.asList("Apple","Pear","Banana")));
    }
}
