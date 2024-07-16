### Understanding
We need to find the median of a list of numbers. The median is the middle number in a list or, if the list 
has an even number of elements, the average of the two middle numbers.

We have a stream of integers that should be added to a container while maintaining the container in an ordered 
state. This way, we will have the ability to retrieve the median at any moment.
### Algorithm
1. Create two heaps (small/large) in ascending and descending order, each represent half of the current list
2. Add element to small heap and then poll to large heap, if large heap size > poll it back
   - When we add to the heap, we need to make sure that the difference between the heap's 
     sizes stays the same (or within 1 if there's an odd number of elements).
3. Simply calculate median

### Solution

```java
class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());;

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
```

### Time/Space Complexity

- Time Complexity: O(log n)
- Space Complexity: O(n)

### Links

https://leetcode.com/problems/find-median-from-data-stream/description/