package datastructure.leetcode.Q3;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, length = 0;
        /**使用set作为滑动窗口来解决字符串或者数组问题*/
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                length = Math.max(length, i - j);
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return length;
    }
}
