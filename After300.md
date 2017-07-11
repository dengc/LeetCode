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