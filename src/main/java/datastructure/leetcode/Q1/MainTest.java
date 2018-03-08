package datastructure.leetcode.Q1;

import org.junit.Test;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/8
 **/
public class MainTest {
    @Test
    public void testTwoSum() {
        MySolution mySolution = new MySolution();
        int[] result = mySolution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
