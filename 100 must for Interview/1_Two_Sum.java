//1. Two Sum
//Map: key为array的值，value为array的index 

public class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++){
			int diff = target - nums[i];
		    if(map.containsKey(diff)){
		        result[1] = i;
		        result[0] = map.get(diff);
		    }
		    map.put(nums[i],i);
		}
		return result;
    }
}