//111. Minimum Depth of Binary Tree
//Recursive: return 1 + min(minDepth(root->left), minDepth(root->right)); 注意任意一边没有的情况
//easy


class Solution {
public:
    int minDepth(TreeNode* root) {
        if(!root){
        	return 0;
        }
        if(!root->left){
        	return 1 + minDepth(root->right);
        }
        if(!root->right){
        	return 1 + minDepth(root->left);
        }
        return 1 + min(minDepth(root->left), minDepth(root->right));
    }
};