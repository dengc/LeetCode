//166. Fraction to Recurring Decimal
//看正负，绝对值，算整数，余数r循环乘10：map<r，位置>，若map里已经有了r，则insert（

class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        string res;
        if (numerator < 0 ^ denominator < 0){
            res += "-";
        }
        long long n = numerator;
        long long d = denominator;
        n = abs(n);
        b = abs(b);
        res += to_string(n / d);
        if (n % d == 0) return res;
        res += ".";
        
        unordered_map<int, int> map;

        for(long long r = n % d; r; r = r % d){
            if(map.count(r)){
                res.insert(map[r], "(");
                res += ")";
                break;
            }
            map[r] = res.size();
            r *= 10;
            res += to_string(r / d);
        }
        return res;
    }
};