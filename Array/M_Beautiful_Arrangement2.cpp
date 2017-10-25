//667. Beautiful Arrangement II
//1, k+1, 2, k, 3, k-1...
//medium
class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> res;
        int a = 1;
        int b = k + 1;
        while(a <= b){
            res.push_back(a++);
            if(a <= b){
                res.push_back(b--);
            }
        }
        for(int i = k+2; i <= n; i++){
            res.push_back(i);
        }
        return res;
    }
};