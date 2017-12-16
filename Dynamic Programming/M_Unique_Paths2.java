//63. Unique Paths II
//new int[m][n] = 上 + 左, 1处为0

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }
                else{
                    if(i == 0 && j == 0){
                        res[i][j] = 1;
                    }
                    else if(i == 0){
                        res[i][j] = res[i][j-1];
                    }
                    else if(j == 0){
                        res[i][j] = res[i-1][j];
                    }
                    else
                        res[i][j] = res[i][j-1] + res[i-1][j];
                }
                
            }
        }
        return res[m-1][n-1];
    }
}