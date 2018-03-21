//121. Best Time to Buy and Sell Stock
//max(每个数-对当前min)

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minNum = INT_MAX;
        int maxNum = 0;
        for(int i = 0; i < prices.size(); i++){
            minNum = min(minNum, prices[i]);
            maxNum = max(maxNum, prices[i] - minNum);
        }
        return maxNum;
    }
};