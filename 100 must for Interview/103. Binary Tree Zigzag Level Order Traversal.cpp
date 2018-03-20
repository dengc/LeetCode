//103. Binary Tree Zigzag Level Order Traversal
//偶数层push val,奇数层insert begin, build(left, d+1), build(right, d+1)

class Solution {
public:
    vector<vector<int>> res;
    void buildVector(TreeNode *root, int depth){
        if(!root) return;
        if(res.size() == depth){
            res.push_back(vector<int>());
        }        
        if (depth % 2 == 0){
            res[depth].push_back(root->val);
        }else{
            res[depth].insert(res[depth].begin(), root->val);
        }
        buildVector(root->left, depth + 1);
        buildVector(root->right, depth + 1);
    }

    vector<vector<int>> zigzagLevelOrder(TreeNode *root) {
        buildVector(root, 0);
        return res;
    }


};