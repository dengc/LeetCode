//611. Valid Triangle Number
//sort;比较第一个数、倒数第二个数、倒数第一个数

class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int res = 0;
        for(int i = nums.size() - 1; i >= 2; i--){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    res += r - l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
};