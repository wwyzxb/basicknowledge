package guavaapi.string;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/28
 **/
public class StringHandling {
    private final static Joiner JOINER = Joiner.on('.').skipNulls();
    private final static Splitter SPLITTER=Splitter.on(",").trimResults();

    public static void main(String[] args){
        String message="Table default.events2 is a base table,we need get it.";
        List<String> list=SPLITTER.splitToList(message);
        for (String s:list){
            System.out.println(s);
        }
    }
}
