//236. Lowest Common Ancestor of a Binary Tree
//traversal左右两边, 都有就return root，不然哪边有return哪边

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    	if(!root || root == p || root == q){
    		return root;
    	}
    	TreeNode* l = lowestCommonAncestor(root->left, p, q);
    	TreeNode* r = lowestCommonAncestor(root->right, p, q);
        if(l && r) return root;
        if(l) return l;
		return r;
    }
};