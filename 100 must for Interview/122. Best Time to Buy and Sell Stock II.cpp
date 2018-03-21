//122. Best Time to Buy and Sell Stock II
//后一个数 - 前一个数

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int res = 0;
        for(int i = 1; i < prices.size(); i++){
            res += max(prices[i] - prices[i-1], 0);
        }
        return res;
    }
};