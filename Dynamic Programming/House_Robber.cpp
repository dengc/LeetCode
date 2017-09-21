//198. House Robber
//result[] store sum of n -> max(with/without the last one)

int rob(vector<int>& nums) {
    int l = nums.size();
    vector<int> result(l+1, 0);
    if(l == 0){
        return 0;
    }
    result[1] = nums[0];
    for(int i = 2; i < l+1; i++){
        result[i] = max(nums[i-1] + result[i-2], result[i-1]);
    }
    return result[l];
}