//611. Valid Triangle Number
//从最后一个数算起，以倒数第二个数和第一个数为基点
//Medium
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int l = nums.length;
        for(int i = l - 1; i > 1; i--){
            int a = 0;
            int b = i - 1;
            while(a < b){
                if(nums[a] + nums[b] > nums[i]){
                    count += b - a;
                    b--;
                }else{
                    a++;
                }
            }
        }
        return count;
    }
}