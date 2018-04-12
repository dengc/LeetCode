//315. Count of Smaller Numbers After Self
//从右往左，lower_bound看sorted array多少数比自己小，然后放入sorted array相应位置

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> sorted;
        vector<int> result(nums.size());
        for(int i = nums.size()-1; i >= 0; i--){
            auto it = lower_bound(sorted.begin(), sorted.end(), nums[i]);
            result[i] = it - sorted.begin();
            sorted.insert(it, nums[i]);
        }
        return result;
    }
};