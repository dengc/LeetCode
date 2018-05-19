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

## 2. Add Two Numbers
``` cpp
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1 && !l2){
            return NULL;
        }
        int a = 0, b = 0;
        ListNode *resL1 = NULL;
        ListNode *resL2 = NULL;
        
        if(l1){
            a = l1->val;
            resL1 = l1->next;
        }
        if(l2){
            b = l2->val;
            resL2 = l2->next;
        }
        
        int firstNum = a + b;
        if(firstNum >= 10){
            firstNum -= 10;
            if(resL1 == NULL){
                resL1 = new ListNode(1);
            }
            else{
                resL1->val++;
            }
        }
        ListNode *res = new ListNode(firstNum);
        
        res->next = addTwoNumbers(resL1,resL2);
        return res;
    }
};
```
## 3. Longest Substring Without Repeating Characters
``` java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
```