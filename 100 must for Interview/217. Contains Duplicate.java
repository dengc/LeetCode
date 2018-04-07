//217. Contains Duplicate
//!set.add 则为true

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet res = new HashSet<>();
        for(int n : nums){
            if(!res.add(n)){
                return true;
            }
        }
        return false;
    }
}