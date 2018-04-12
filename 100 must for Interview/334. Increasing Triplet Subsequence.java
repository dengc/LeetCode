//334. Increasing Triplet Subsequence
//每次看num是不是最小数，然后看是不是第二小数，大于两个最小数则为true

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min1){
                min1 = num;
            }else if (num <= min2) {
                min2 = num;
            }else{
                return true;
            }
        }
        return false;
    }
}