//108. Convert Sorted Array to Binary Search Tree
//mid为nums中间数，左—>low到mid-1, 右->mid+1到high

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return build(nums, 0, nums.size()-1);
    }

    TreeNode* build(vector<int>& nums, int low, int high) {
        if(low > high){
        	return nullptr;
        }

        int mid = (low + high) / 2;
        TreeNode* tree = new TreeNode(nums[mid]);
        tree->left = build(nums, low, mid-1);
        tree->right = build(nums, mid+1, high);

        return tree;
    }
};