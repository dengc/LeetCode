//300. Longest Increasing Subsequence
//new int[]: 对于每一个数，和前面所有数作比较，记录包含自己path的length

class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if(l == 0) return 0;
        int[] len = new int[l];
        int res = 1;
        for(int i = 0; i < l; i++){
            len[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            res = Math.max(res, len[i]);
        }
        return res;
    }
}