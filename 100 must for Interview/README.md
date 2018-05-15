# Leetcode 100 for Interview

@(IT Studies)


-------------------

[TOC]


## 1. Two Sum
``` java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                res[1] = i;
                res[0] = map.get(diff);
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
```
