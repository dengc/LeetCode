//213. House Robber II
//第n家不rob or 第1家不rob

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robFromTo(nums, 0, nums.length-1), robFromTo(nums, 1, nums.length));
        
    }
    public int robFromTo(int[] nums, int start, int end){
        int robThis = 0;
        int notRobThis = 0;
        for(int i = start; i < end; i++){
            int temp = robThis;
            robThis = notRobThis + nums[i];
            notRobThis = Math.max(notRobThis, temp);
        }
        return Math.max(robThis, notRobThis);
    }
}