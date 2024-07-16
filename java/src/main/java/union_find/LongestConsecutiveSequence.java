package union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. Longest Consecutive Sequence
 * URL: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">...</a>
 * Leetcode Level: Hard
 * The solution unions each number with its consecutive neighbors if they exist, effectively merging consecutive sequences.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    private static final Map<Integer, Integer> parent = new HashMap<>();
    private static final Map<Integer, Integer> size = new HashMap<>();

    public static int longestConsecutive(int[] nums) {
        for (int num : nums) {
            // Skip if the number is already in the parent map (we can have [1,2,0,1] and 1 is already in the map)
            if(parent.containsKey(num)) continue;
            size.put(num, 1);
            parent.put(num, num);
            if(parent.containsKey(num - 1)) union(num - 1, num);
            if(parent.containsKey(num + 1)) union(num + 1, num);
        }

        int max = 0;
        for(int num : nums) {
            int root = find(num);
            max = Math.max(max, size.get(root));
        }

        return max;
    }

    private static int find(int x) {
        if(parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private static void union(int x, int y) {
        int setx = find(x);
        int sety = find(y);
        if(size.get(setx) < size.get(sety)) {
            parent.put(setx, sety);
            size.put(sety, size.get(setx) + size.get(sety));
        } else {
            parent.put(sety, setx);
            size.put(setx, size.get(setx) + size.get(sety));
        }
    }
}
