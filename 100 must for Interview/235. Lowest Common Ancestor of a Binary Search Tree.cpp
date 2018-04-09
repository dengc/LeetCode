//235. Lowest Common Ancestor of a Binary Search Tree
//在两个node中间，则为ancestor：若小于min，则往右找；大于max，则往左找

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root->val < min(p->val, q->val)){
            return lowestCommonAncestor(root->right, p, q);
        }
        if(root->val > max(p->val, q->val)){
            return lowestCommonAncestor(root->left, p, q);
        }
        return root;
    }
};