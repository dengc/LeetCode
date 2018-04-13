//329. Longest Increasing Path in a Matrix
//DFS:上下左右 + 1

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int[][] countMatrix = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, Integer.MIN_VALUE, i, j, countMatrix));
            }
        }
        return res;
    }
    public int dfs(int[][] matrix, int val, int i, int j, int[][] countMatrix){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] <= val){
            return 0;
        }
        if(countMatrix[i][j] != 0){
            return countMatrix[i][j];
        }
        int up = dfs(matrix, matrix[i][j], i-1, j, countMatrix) + 1;
        int down = dfs(matrix, matrix[i][j], i+1, j, countMatrix) + 1;
        int left = dfs(matrix, matrix[i][j], i, j-1, countMatrix) + 1;
        int right = dfs(matrix, matrix[i][j], i, j+1, countMatrix) + 1;
        countMatrix[i][j] = Math.max(up, Math.max(down, Math.max(left, right)));
        return countMatrix[i][j];
    }
}