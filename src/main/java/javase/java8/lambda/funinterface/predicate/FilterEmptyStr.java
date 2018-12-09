package javase.java8.lambda.funinterface.predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: wuxiaobing
 * @Date 2018/2/3
 **/
public class FilterEmptyStr {
    /**逻辑处理函数*/
    public List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> resultList = new ArrayList<>();
        for (String str : list) {
            /**udclassloader()函数的具体逻辑交给Lambda表达式去实现*/
            if (predicate.test(str)) {
                resultList.add(str);
            }
        }
        return resultList;
    }

    @Test
    public void testFilterEmptyStr(){
        List<String> initialList= Arrays.asList("str1","","str2","","str3","");
        List<String> resultList=filter(initialList,(String str)->!str.isEmpty());
        System.out.println(resultList);
    }
}
