# Leetcode2

@(IT Studies)


-------------------

[TOC]

## Easy (after 300)
-------------------

### 326. Power of Three
-- 正数除尽3
``` java
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
```
### 344. Reverse String
-- StringBuffer
``` java
public class Solution {
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
```
### 628. Maximum Product of Three Numbers
-- sort, 后3 or 后1前2
``` java
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return Math.max(nums[l-1] * nums[l-2] * nums[l-3], nums[l-1]*nums[0]*nums[1]);
    }
}
```
### 633. Sum of Square Numbers
-- 判断整数：floor == 自己？
``` java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= Math.sqrt(c); i++){
            if(Math.floor(Math.sqrt(c - i * i)) == Math.sqrt(c - i * i)){
                return true;
            }
        }
        return false;
    }
}
```
### 637. Average of Levels in Binary Tree
-- queue push & pop
``` cpp
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> res;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            double sum = 0;
            int l = q.size();
            for(int i = 0; i < l; i++){
                sum += q.front()->val;
                if(q.front()->left){
                    q.push(q.front()->left);
                }
                if(q.front()->right){
                    q.push(q.front()->right);
                }
                q.pop();
            }
            sum /= l;
            res.push_back(sum);
        }
        return res;
    }
};
```