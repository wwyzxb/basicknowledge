package datastructure.leetcode.Q1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class MySolution {
    public int[] twoSum(int[] nums, int target) {
        /**key:num,value:pos
         * 1.把数组中的每一个val作为key，下标作为value放入map中
         * 2.val2=target-val1，接着判断map中是否有val2的key
         * 3.如果存在，则将取出val2对应的value
         * 4.如果不存在，则将<val,pos>放入map中
         * */
        Map<Integer, Integer> temp = new HashMap();
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int val1 = nums[i];
            int val2 = target - val1;
            if (temp.containsKey(val2)) {
                int pos1 = temp.get(val2);
                int pos2 = i;
                result = new int[]{pos1, pos2};
            } else {
                temp.put(val1, i);
            }
        }
        return result;
    }
}
