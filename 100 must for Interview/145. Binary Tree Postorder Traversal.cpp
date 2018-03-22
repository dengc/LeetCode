//145. Binary Tree Postorder Traversal
//stack, 每次先进left再right，insert到begin

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        stack<TreeNode *> s;
        TreeNode *p = NULL;
        s.push(root);
        while(!s.empty()){
            p = s.top();
            s.pop();
            res.insert(res.begin(), p->val);
            if(p->left){
                s.push(p->left);
            }
            if(p->right){
                s.push(p->right);
            }
        }
        return res;
    }
};