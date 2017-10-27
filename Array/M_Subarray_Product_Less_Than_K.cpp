//713. Subarray Product Less Than K
//从左往右一个一个除
//Medium
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if (k <= 1){
            return 0;
        }
        int l = nums.size(), product = 1, count = 0, front = 0;
        for (int i = 0; i < l; i++) {
            product *= nums[i];
            while (product >= k){
                product /= nums[front++];
            } 
            count += i - front + 1;
        }
        return count;
    }
};