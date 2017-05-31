# Leetcode

@(IT Studies)


-------------------

[TOC]

## Easy
-------------------

### 1. Two Sum
-- map
``` java
public class Solution {
    public int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums.length; i++){
		    if(map.containsKey(target - nums[i])){
		        result[1] = i;
		        result[0] = map.get(target - nums[i]);
		    }
		    map.put(nums[i],i);
		}
		return result;
    }
}
```
### 7. Reverse Integer
-- %findlast, /10
``` java
public class Solution {
    public static int reverse(int x) {
		long result = 0;
		while(x != 0){
			result = x % 10 + result * 10;
			x /= 10;
		}
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ){
			return 0;
		}
		return (int) result;
    }
}
```
### 9. Palindrome Number
-- string -> toCharArray
``` java
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String word = Integer.toString(x);
        char[] nums = word.toCharArray();
        int l = word.length();
        for(int i = 0; i <= l/2; i++){
        	if(nums[i] != nums[l-1-i]){
        		return false;
        	}
        }
        return true;
    }
}
```
### 13. Roman to Integer
-- 左：小减大加
``` java
public class Solution {
    public int romanToInt(String s) {
        int l = s.length();
		int result = 0;
		for(int i = 0; i < l; i++){
			int num1 = basicRomanInt(s.substring(i,i+1));
			if(i < l-1){
				int num2 = basicRomanInt(s.substring(i+1,i+2));
				if(num1 < num2){
					num1 = -num1;
				}
			}
			result += num1;
		}
		return result;
    }

    public int basicRomanInt(String s){
		if(s.equals("I")){
			return 1;
		}
		if(s.equals("V")){
			return 5;
		}
		if(s.equals("X")){
			return 10;
		}
		if(s.equals("L")){
			return 50;
		}
		if(s.equals("C")){
			return 100;
		}
		if(s.equals("D")){
			return 500;
		}
	    return 1000;
	}
}
```
