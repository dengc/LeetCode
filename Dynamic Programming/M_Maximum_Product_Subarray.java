//152. Maximum Product Subarray
//每次记录最大和最小（有负数）

class Solution {
    public int maxProduct(int[] nums) {
        int l = nums.length;
        if(l == 0){
            return 0;
        }
        int max = res[0], min = max, res = max;
        for(int i = 1; i < l; i++){
            int temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}