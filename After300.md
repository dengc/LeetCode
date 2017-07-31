# Leetcode2

@(IT Studies)


-------------------

[TOC]

## Easy (after 300)
-------------------

### 303. Range Sum Query - Immutable
-- nums[i] = nums[i] + nums[i - 1]
``` java
public class NumArray {
    int[] input;
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] = nums[i] + nums[i - 1];
        input = nums;
    }
    public int sumRange(int i, int j) {
        if(i == 0)
            return input[j];
        return input[j] - input[i - 1];
    }
}
```
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
### 342. Power of Four
-- 正数除尽4
``` java
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0){
            return false;
        }
        while(num % 4 == 0){
            num /= 4;
        }
        return num == 1;
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
### 345. Reverse Vowels of a String
-- char[] -> new string(ch)
``` java
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        ArrayList<Character> alist = new ArrayList<Character>();
        char[] ch = s.toCharArray();
        int l = s.length();
        for(int i = 0; i < l; i++){
            if(vowels.contains(ch[i])){
                alist.add(ch[i]);
            }
        }
        int aSize = alist.size();
        for(int i = 0; i < l; i++){
            if(vowels.contains(ch[i])){
                ch[i] = alist.get(--aSize);
            }
        }
        String res = new String(ch);
        return res;
    }
}
```
### 349. Intersection of Two Arrays
-- set & arraylist
``` java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1){
            set.add(num);
        }
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int num : nums2){
            if(set.contains(num) && !alist.contains(num)){
                alist.add(num);
            }
        }
        int l = alist.size();
        int[] res = new int[l];
        for(int i = 0; i < l; i++){
            res[i] = alist.get(i);
        }
        return res;
    }
}
```
### 350. Intersection of Two Arrays II
-- map & arraylist
``` java
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                alist.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int l = alist.size();
        int[] res = new int[l];
        for(int i = 0; i < l; i++){
            res[i] = alist.get(i);
        }
        return res;
    }
}
```
### 367. Valid Perfect Square
-- r = (r + num / r) / 2
``` java
public class Solution {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while(r * r > num){
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
}
```
### 371. Sum of Two Integers
-- ^, &, <<1
``` java
public class Solution {
    public int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}
```
### 414. Third Maximum Number
-- long, m1 & m2 & m3
``` java
public class Solution {
    public int thirdMax(int[] nums) {
        int m1 = nums[0];
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        int l = nums.length;
        for(int i = 1; i < l; i++){
            if(nums[i] > m1){
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            }
            else if(nums[i] < m1 && nums[i] > m2){
                m3 = m2;
                m2 = nums[i];
            }
            else if(nums[i] < m2 && nums[i] > m3){
                m3 = nums[i];
            }
        }
        if(m3 > Long.MIN_VALUE){
            return (int) m3;
        }
        return m1;
    }
}
```
### 415. Add Strings
-- string[] 相加，string insert
``` cpp
class Solution {
public:
    string addStrings(string num1, string num2) {
        int sum = 0, i = num1.length() - 1, j = num2.length() - 1;
        string str;
        while (i >= 0 || j >= 0 || sum > 0) {
            if (i >= 0){
                sum += (num1[i--] - '0');
            }
            if (j >= 0){
                sum += (num2[j--] - '0');
            } 
            str.insert(0, 1, (sum % 10) + '0');
            sum /= 10;
        }
        return str;
    }
};
```
### 504. Base 7
-- %进制base = 每一位，while(/base)
``` cpp
class Solution {
public:
    string convertToBase7(int num) {
        int n = abs(num); string res;
        do{
            res = to_string(n % 7) + res;
        } while(n /= 7);
        return num >= 0 ? res : '-' + res;   
    }
};
```
### 507. Perfect Number
-- sum += i + (num / i)
``` cpp
class Solution {
public:
    bool checkPerfectNumber(int num) {
        int sum = 1;
        for(int i = 2; i <= (int) sqrt(num); i++){
            if(num % i == 0){
                sum += i + (num / i);
            }
        }
        return sum == num && num != 1;
    }
};
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