//124. Binary Tree Maximum Path Sum
//子path返回 val+max(left,right)

class Solution {
public:
    int res = INT_MIN;
    int maxPathSum(TreeNode* root) {
        subPath(root);
        return res;
    }

    int subPath(TreeNode *root){
        if(!root) return 0;
        int left = max(subPath(root->left), 0);
        int right = max(subPath(root->right), 0);
        res = max(res, left + right + root->val);
        return root->val + max(left, right);
    }
};