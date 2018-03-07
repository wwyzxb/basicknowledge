package datastructure.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static int[] twoSum(int[] nums, int target) {
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

    public static void main(String[] args){
        int[] result=   twoSum(new int[]{2,7,11,15},9);
        for(int r:result){
            System.out.println(r);
        }
    }

}
