//172. Factorial Trailing Zeroes
//循环除5，商相加 （每多乘一个5，就多一个0）

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0){
            n /= 5;
            res += n;
        }
        return res;
    }
}