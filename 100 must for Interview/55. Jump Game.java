//55. Jump Game
//看每个数最远到哪里 i+nums[i]

class Solution {
    public boolean canJump(int[] nums) {
    	int farest = 0;
        for(int i = 0; i < nums.length; i++){
        	if(i > farest){
        		return false;
        	}
        	farest = Math.max(farest, i+nums[i]);
        }
        return true;
    }
}