//371. Sum of Two Integers
//bitwise ^ : 不一样就是1 (1+0); &: 都是1才是1; <<: 往左进一位

class Solution {
public:
    int getSum(int a, int b) {
        int sum = a;
        while(b != 0){
            sum = a^b;
            b = (a&b) << 1;
            a = sum;    
        }
        return sum;
    }
};