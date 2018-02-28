//53. Maximum Subarray
//nums[i]: 加自己 or 只有自己

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
		int maxWith = max;

		for(int i = 1; i < nums.length; i++){
			maxWith = Math.max(maxWith + nums[i], nums[i]);
			max = Math.max(max, maxWith);
		}
		return max;
    }
}