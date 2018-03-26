//174. Dungeon Game
//建立一个n+1个正无穷数的数组int[], 倒数第二个数为1，然后从右往左减dungeon[][]里的数为当前血量

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] res = new int[n+1];
        for(int i = 0; i < n+1; i++){
        	res[i] = Integer.MAX_VALUE;
        }
        res[n-1] = 1;
        for(int i = m - 1; i >= 0; i--){
        	for(int j = n - 1; j >= 0; j--){
        		//j为向下走，j+1为向右走
        		int min = Math.min(res[j], res[j+1]);
        		min -= dungeon[i][j];
        		if(min < 1){
        			min = 1;
        		}
        		res[j] = min;
        	}
        }
        return res[0];
    }
}