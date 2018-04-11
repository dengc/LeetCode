//289. Game of Life
//new int[][]用0环绕board，count 1数量

class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        int[][] temp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                temp[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int count = countOnes(temp,i,j);
                if(count < 2 || count > 3){
                    board[i][j] = 0;
                }
                else if (count == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    public int countOnes(int[][] board, int m, int n){
        int count = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] temp = new int[row+2][col+2];
        for(int i = 1; i < row+1; i++){
            for(int j = 1; j < col+1; j++){
                temp[i][j] = board[i-1][j-1];
            }
        }
        for(int i = m; i < m+3; i++){
            for(int j = n; j < n+3; j++){
                if(temp[i][j] == 1){
                    count++;
                }
            }
        }
        if(temp[m+1][n+1] == 1){
            count--;
        }
        return count;
    }
}