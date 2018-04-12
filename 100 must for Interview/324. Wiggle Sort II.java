//324. Wiggle Sort II
//sort; median及其左边放在偶数位，右边放在奇数位，从大到小

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int[] res = new int[l];
        for(int i = 0; i < l; i += 2){
            res[i] = nums[(l-1-i)/2];
        }
        for(int i = 1; i < l; i += 2){
            res[i] = nums[(l-i/2-1];
        }
        for(int i = 0; i < l; i++){
            nums[i] = res[i];
        }
    }
}