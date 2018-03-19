//102. Binary Tree Level Order Traversal
//push val, build(left, d+1), build(right, d+1)

class Solution {
public:
    vector<vector<int>> res;
    void buildVector(TreeNode *root, int depth){
        if(!root) return;
        if(res.size() == depth){
            res.push_back(vector<int>());
        }
        res[depth].push_back(root->val);
        buildVector(root->left, depth + 1);
        buildVector(root->right, depth + 1);
    }

    vector<vector<int>> levelOrder(TreeNode *root) {
        buildVector(root, 0);
        return res;
    }
};