//96. Unique Binary Search Trees
//1, 2, 3, .. n as root = 左subTree + 右subTree

class Solution {
    public int numTrees(int n) {
        int [] res = new int[n+1];
        res[0]= 1;
        res[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                res[level] += res[root-1] * res[level-root];
        return res[n];
    }
}