//322. Coin Change
//new int[amount+1], 每一个amount数量 = 1 + （amount - 其中一个coin数量)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        for(int i = 1; i < amount + 1; i++){
        	res[i] = Integer.MAX_VALUE;
        	for(int coin : coins){
        		int diff = i - coin;
        		if(diff >= 0 && res[diff] != Integer.MAX_VALUE){
        			res[i] = Math.min(res[i], res[diff] + 1);
        		}
        	}
        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }
}