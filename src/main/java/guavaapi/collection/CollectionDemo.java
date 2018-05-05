package guavaapi.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/28
 **/
public class CollectionDemo {
    private final static Set<String> set = Sets.newHashSet("China", "USA", "BRITAIN");
    private final static List<String> list= Lists.newArrayList("China", "China", "BRITAIN");

    private final static Set<String> set1 = new HashSet<>();
    private final static List<String> list1 = new ArrayList<>();

    static {
        set1.add("China");
        set1.add("USA");
        set1.add("BRITAIN");

        list1.add("China");
        list1.add("China");
        list1.add("BRITAIN");
    }

    public static void main(String[] args) {
        for (String s : list1) {
            System.out.println(s);
        }
        list1.get(0);
    }
}
