### Understanding
Get sorted list of numbers by frequency and get k elements
### Algorithm
(Heap)
1. Create HashMap with key/frequency
2. Create a heap that will sort number by frequency
3. Return k numbers

### Solution

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            qu.add(entry.getKey());
            if (qu.size() > k) {
                qu.poll(); // remove the element with the lowest frequency
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = qu.remove();
        }
        return res;
    }
}
```

### Time/Space Complexity

- Time Complexity: O(n log k)
- Space Complexity: O(n)

### Links

https://leetcode.com/problems/top-k-frequent-elements/description/