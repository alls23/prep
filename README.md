
## About The Project
...

## Binary Seatch
### Search based on index
Is possible because the array is sorted
  * 153 Find Minimum in Rotated Sorted Array:
  ```
  Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
  There is only one repeated number in nums, return this repeated number.
  You must solve the problem without modifying the array nums and uses only constant extra space.
  ```
  ```java
  public int findMin(int[] nums) {
        if(nums.length < 2) return nums[0];
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while(leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if(nums[midIndex] > nums[rightIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex;
            }
        }
        return nums[leftIndex];
    }
  ```






