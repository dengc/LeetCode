//41. First Missing Positive
//

class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        for(int i = 0; i < l; i++){
            while(nums[i] > 0 && nums[i] <= l && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < l; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return l+1;
    }
    public void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}