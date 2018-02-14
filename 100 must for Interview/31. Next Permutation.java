//31. Next Permutation
//swap & reverse

class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        if(l < 2){
            return;
        }
        int index = l - 1;
        while(index > 0){
            if(nums[index-1] < nums[index]){
                break;
            }
            index--;
        }
        if(index == 0){
            reverse(nums, 0, l-1);
        }else {
            int i = l - 1;
            while(i >= index){
                if(nums[i] > nums[index-1]){
                    swap(nums, index-1, i);
                    reverse(nums, index, l-1);
                    break;
                }
                i--;
            }
        }
        return;
    }
    public void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
    public void reverse(int[] nums, int s, int e){
        for(int i = s; i <= (s + e)/2; i++){
            swap(nums, i, s+e - i);
        }
    }
}