//239. Sliding Window Maximum
//每次的max = 新数大为新数; 旧数小为上一个的max；否则for loop 非O(n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int l = nums.length;
    	if(l == 0) return new int[0];
       
        int [] res = new int[l - k + 1];
        l = res.length;
        for(int i = 0; i < l; i++){
        	res[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < k; i++){
        	res[0] = Math.max(res[0], nums[i]);
        }
        for(int i = 1; i < l; i++){
        	if(nums[i+k-1] > res[i - 1]){
        		res[i] = nums[i+k-1];
        	}
        	else if(nums[i-1] < res[i-1]){
        		res[i] = res[i-1];
        	}
        	else{
                for(int j = i; j < i + k; j++){
                	res[i] = Math.max(res[i], nums[j]);
                }
        	}
        }
        return res;
    }
}