//11. Container With Most Water
//先算最宽，然后再算中间 only if height is higher

class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int h = 0;
        int res = 0;

        while(left < right){
        	h = min(height[left], height[right]);
        	res = max(res, h * (right - left));

        	while(height[left] <= h){
        		left++;
        	}
        	while(height[right] <= h){
        		right--;
        	}
        }
        return res;
    }
};