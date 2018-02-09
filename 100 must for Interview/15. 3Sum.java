//15. 3Sum
//先sort array, 两个pointer，一左一右向中间靠拢求和；avoid duplicate

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        
        for(int i = 0; i < nums.length - 2; i++){
        	if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	        	int lo = i + 1;
	        	int hi = nums.length - 1;
	        	int sum = - nums[i];
	        	while(lo < hi){
	        		if(nums[lo] + nums[hi] < sum){
	        			lo++;
	        		}else if (nums[lo] + nums[hi] > sum) {
	        			hi--;
	        		}else {
	        			res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	        			lo++;
	        		}
	        	}
	        }
        }
        return res;
    }
}