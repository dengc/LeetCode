//697. Degree of an Array
//map计次数，找最大，两头减

class Solution {
    public int findShortestSubArray(int[] nums) {
	    int l = nums.length;
    	if(l == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        for(int n : nums){
        	map.put(n, map.getOrDefault(n, 0) + 1);
        	count = Math.max(count, map.get(n));
        }
	    for (int n : nums) {
        	if(map.get(n) == count){
        		arr.add(n);
        	}
	    }
	    int res = Integer.MAX_VALUE;
	    for(int i = 0; i < arr.size(); i++){
	    	int start = 0;
	    	int end = l-1;
	    	while(nums[start] != arr.get(i)){
	    		start++;
	    	}
	    	while(nums[end] != arr.get(i)){
	    		end--;
	    	}
	    	int newRes = end - start + 1;
	    	res = Math.min(newRes, res);
	    }
	    return res;
    }
}