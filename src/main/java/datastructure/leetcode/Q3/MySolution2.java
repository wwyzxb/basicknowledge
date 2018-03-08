package datastructure.leetcode.Q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MySolution2 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, length = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                ch = s.charAt(i);
                map.put(ch, i);
                length = Math.max(length, i - j + 1);
                i++;
            } else {
                /**map中有可能取到之前较小的下标，所以j需要取较大的下标：
                 * 比如：abba
                 * a:0
                 * b:1
                 * b:2
                 * a:3
                 * 当i=3,j=2时，j=map.get(a) + 1的结果就变成了1，产生了错误
                 * */
                j = Math.max(map.get(ch) + 1, j);
                map.remove(ch);
            }
        }
        return length;
    }
}
