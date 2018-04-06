//202. Happy Number
//new Set; n%10平方，n/10

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
        	int sum = 0;
        	while(n > 0){
        		int rend = n % 10;
        		sum += rend * rend;
        		n /= 10;
        	}
        	if(sum == 1){
        		return true;
        	}
        	n = sum;
        }
        return false;
    }
}