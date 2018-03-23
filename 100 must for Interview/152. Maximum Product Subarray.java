//152. Maximum Product Subarray
//对于每一个数：记录包含自己的max和min，(乘max或乘min或自己)，res=max(res,max)

class Solution {
    public int maxProduct(int[] nums) {
        int l = nums.length;
        if(l == 0) return 0;
        int max = nums[0], min = max, res = max;
        for(int i = 1; i < l; i++){
            int temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}