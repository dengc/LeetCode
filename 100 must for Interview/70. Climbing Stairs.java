//70. Climbing Stairs
//new int[n+1];

class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return n;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for(int i = 3; i < n + 1; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
}