//91. Decode Ways
//array: memo[i] = memo[i+1]+memo[i+2] 或 memo[i] = memo[i+1];

class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        if (l == 0){
        	return 0;
        }
        int[] memo = new int[l+1];
        memo[l]  = 1;
        if(s.charAt(l-1) != '0'){
        	memo[l-1] = 1;
        }else {
        	memo[l-1] = 0;
        }
        
        for(int i = l-2; i >= 0; i--){
        	if(s.charAt(i) != '0'){
        		int n = Integer.parseInt(s.substring(i,i+2));
        		if(n <= 26){
        			memo[i] = memo[i+1]+memo[i+2];
        		}else {
        			memo[i] = memo[i+1];
        		}
        	}
        }
        
        return memo[0];
    }
}