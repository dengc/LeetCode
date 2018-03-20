//114. Flatten Binary Tree to Linked List
//把左边的放右边，把右边的放在其下边

class Solution {
public:
    void flatten(TreeNode* root) {
        if(!root) return;
        flatten(root->left);
        flatten(root->right);
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        root->left = NULL;
        root->right = left;
        while(root->right){
            root = root->right;
        }
        root->right = right;
    }
};