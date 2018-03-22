//128. Longest Consecutive Sequence
//新set装入所有数，看每个数-- 和每个数++ 连续能有多少

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums){
        	set.add(n);
        }
        int res = 0;
        for(int n : nums){
        	if(set.contains(n)){
        		int l = 1;
        		int next = n - 1;
        		while(set.contains(next)){
        			l++;
        			set.remove(next);
        			next--;
        		}
        		next = n + 1;
        		while(set.contains(next)){
        			l++;
        			set.remove(next);
        			next++;
        		}
        		res = Math.max(l, res);
        	}
        }
        return res;
    }
}