//200. Number of Islands
//把一个1及其四周都变成0；一个新的1则return 1

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                res += turn0(grid, i, j);
            }
        }
        return res;
    }
    public int turn0(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        turn0(grid,i-1,j);
        turn0(grid,i+1,j);
        turn0(grid,i,j-1);
        turn0(grid,i,j+1);
        return 1;
    }
}