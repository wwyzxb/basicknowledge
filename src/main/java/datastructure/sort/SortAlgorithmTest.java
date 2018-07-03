package datastructure.sort;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author: wuxiaobing
 * @Date 2018/7/3
 **/
public class SortAlgorithmTest {
    int[] array;
    SortAlgorithm sort;

    @Before
    public void setUp() throws Exception {
        sort = new SortAlgorithm();
        array = new int[]{4, 5, 3, 9, 7, 4, 8, 1, 2, 0};
    }

    public List<Integer> convertArrayToList(int[] array) {
        List<Integer> list = Lists.newArrayList();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    @Test
    public void insertSort() throws Exception {
        sort.insertSort(array);
        System.out.println(convertArrayToList(array));
    }

    @Test
    public void shellInsert() throws Exception {
        sort.shellInsert(array);
        System.out.println(convertArrayToList(array));
    }

}