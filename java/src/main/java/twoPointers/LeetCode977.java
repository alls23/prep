package twoPointers;

/**
 * 977. Squares of a Sorted Array
 * URL: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">...</a>
 * Leetcode Level: Easy
 *
 * We have sorted arrays of int's so we will use two pointers in loop, loop will start from the end
 * of the array. Then will check for index "i" which absolute value of element is greater, left or right pointer
 * and then will add that element to the end (i) of the result array.
 *
 */
class LeetCode977 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] cost = {-4,-1,0,3,10};
        System.out.println(sortedSquares(cost));

    }





















    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = Math.abs(nums[right]) * Math.abs(nums[right]);
                right--;
            } else {
                result[i] = Math.abs(nums[left]) * Math.abs(nums[left]);
                left++;
            }
        }
        return result;
    }
}
