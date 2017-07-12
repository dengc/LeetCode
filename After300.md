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