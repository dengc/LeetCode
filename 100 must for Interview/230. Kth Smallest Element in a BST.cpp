//230. Kth Smallest Element in a BST
//新vector<int>, 每次inorder左、push自己val、inorder右

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> res;
        inorder(root, res);
        return res[k-1];
    }
    void inorder(TreeNode* root, vector<int> &vec){
        if(!root) return;
        inorder(root->left, vec);
        vec.push_back(root->val);
        inorder(root->right, vec);
    }
};