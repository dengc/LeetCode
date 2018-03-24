//198. House Robber
//对于每一家，rob 或 不rob (前一个rob或不rob)

public class Solution {
    public int rob(int[] nums) {
        int robThis = 0;
        int notRobThis = 0;
        for(int n : nums){
        	int temp = robThis;
        	robThis = n + notRobThis;
        	notRobThis = Math.max(notRobThis, temp);
        }
        return Math.max(robThis, notRobThis);
    }
}