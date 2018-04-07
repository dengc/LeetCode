//215. Kth Largest Element in an Array
//sort, 第l-k个数

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}