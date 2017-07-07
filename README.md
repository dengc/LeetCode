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
### 14. Longest Common Prefix
-- 
``` cpp
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = "";
        for(int idx=0; strs.size()>0; prefix+=strs[0][idx], idx++)
            for(int i=0; i<strs.size(); i++)
                if(idx >= strs[i].size() ||(i > 0 && strs[i][idx] != strs[i-1][idx]))
                    return prefix;
        return prefix;
    }
};
```
### 20. Valid Parentheses
-- replace 括号
``` java
public class Solution {
    public boolean isValid(String s) {
        int l = 0;
        
        while(l != s.length()){
            l = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        
        return l == 0;
    }       
}
```
### 21. Merge Two Sorted Lists
-- Recursion: mergeTwoLists == 最小值
``` cpp
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL){
            return l2;
        }  
        if (l2 == NULL){
            return l1;
        }
        
        if (l1->val < l2->val){
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
        else { 
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};
```
### 26. Remove Duplicates from Sorted Array
-- 加入不同element: 后面 > 前边，则加后面的
``` java
public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if(l < 2){
            return l;
        }
        
        l = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] != nums[i-1]) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
```
### 27. Remove Element
-- 加入特定的element: 不等于val，则加入
``` java
public class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != val){
                nums[l++] = nums[i]; 
            }
        }
        return l;
    }
}
```
### 28. Implement strStr()
-- indexOf
``` java
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
```
### 35. Search Insert Position
-- 找大于等于target的index
``` java
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
```
### 38. Count and Say
-- Recursion：前一个element. toCharArray()，count,  StringBuilder.append
``` java
public class Solution {
    public String countAndSay(int n) {
        if(n <= 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        char cur = str.charAt(0);
        int count = 1;
        char[] arr = str.toCharArray();
        for(int i = 1; i < arr.length; i++) {
            if(cur == arr[i]) {
                count++;
            } 
            else {
                sb.append(count);
                sb.append(cur);
                cur = arr[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
}
```
### 53. Maximum Subarray
-- 对于每个数，先带上自己（加自己 or 只有自己），然后比较带 or 不带
``` java
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxWith = max;
        for(int i = 1; i < nums.length; i++){
            maxWith = Math.max(maxWith + nums[i], nums[i]);
            max = Math.max(max, maxWith);
        }
        return max;
    }
}
```
### 58. Length of Last Word
-- trim() 去首尾空格，lastIndexOf(" ")
``` java
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - 1 - s.lastIndexOf(" ");
    }
}
```
### 66. Plus One
-- 逢9变0，非9最右边的数+1；（若全9）加一位，最左1 其余0
``` java
public class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        while(l > 0 && digits[l - 1] == 9 ){
            digits[l - 1] = 0;
            l--;
        }
        if(l > 0){
            digits[l - 1] += 1;
            return digits;
        }
        l = digits.length;
        int[] newDigits = new int[l+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
```
### 67. Add Binary
-- StringBuilder, 
``` java
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int carry = 0;
        while(la > -1 || lb > -1){
            int sum = carry;
            if(la > -1){
                sum += a.charAt(la--) - '0';
            }
            if(lb > -1){
                sum += b.charAt(lb--) - '0';
            }
            sb.append(sum % 2);
            carry = sum/2;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
```
### 69. Sqrt(x)
-- 
``` python
class Solution(object):
    def mySqrt(self, x):
        r = x
        while r * r > x:
            r = (r + x/r) / 2
        return r
```
### 70. Climbing Stairs
-- new int[n+1]
``` java
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3; i < n+1; i++){
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
```
### 83. Remove Duplicates from Sorted List
-- 
``` cpp
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *p = head;
        if(!head){
            return head;
        }
        while(p->next){
            ListNode *q = p->next;
            if(p->val == q->val){
                p->next = q->next;
                delete q;
            }
            else{
                p = q;
            }
        }
        return head;
    }
};
```
### 88. Merge Sorted Array
-- 最大数比较，大的存入A[index]
``` java
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1 ;
        int indexB = n - 1 ;
        int index = m + n - 1 ;
        while(indexA >= 0 && indexB >= 0){
            if(A[indexA] > B[indexB]){
                A[index--] = A[indexA--] ;
            }else{
                A[index--] = B[indexB--] ;
            }
        }
        while(indexB >= 0){
            A[index--] = B[indexB--] ;
        }
    }
}
```
### 100. Same Tree
-- Recursion: check Null -> 自己的val -> 看左&&右
``` cpp
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p == NULL||q== NULL){
            return (p==q);
        }
        if(p->val != q->val){
            return false;
        }
        return isSameTree(p->left,q->left) && isSameTree(p->right,q->right);
    }
};
```
### 101. Symmetric Tree
-- Recursion: (new Method 2 parameters) check Null ->自己的val && 看左&&右
``` cpp
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return isSym(root, root);
    }
    
    bool isSym(TreeNode* t1, TreeNode* t2){
        if(t1 == NULL || t2 == NULL){
            return (t1 == t2);
        }
        return (t1->val == t2->val) && isSym(t1->left, t2->right) && isSym(t2->left, t1->right);
        
    }
};
```
### 104. Maximum Depth of Binary Tree
-- Recursion: check Null -> 1+ max(左，右)
``` cpp
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        return 1 + max(maxDepth(root->left), maxDepth(root->right));
    }
};
```
### 107. Binary Tree Level Order Traversal II
-- Recursive
``` cpp
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        add(res, 0, root);
        return res;
    }
    
    public void add(LinkedList<List<Integer>> list, int l, TreeNode n){
        if(n == null){
            return;
        }
        if(list.size() - 1 < l){
            list.addFirst(new LinkedList<Integer>());
        }
        list.get(list.size() - 1 - l).add(n.val);
        add(list, l+1, n.left);
        add(list, l+1, n.right);
    }
}
```
### 108. Convert Sorted Array to Binary Search Tree
-- Recursive: 中间node, build left & right
``` java
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length -1);
    }
    
    public TreeNode build(int[] nums, int low, int high){
        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = build(nums, low, mid - 1);
        n.right = build(nums, mid + 1, high);
        return n;
    }
}
```
### 110. Balanced Binary Tree
-- Recursive
``` cpp
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        int left = depth(root->left);
        int right = depth(root->right);
        return abs(left-right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
    
    int depth(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        return max(depth(root->left), depth(root->right)) + 1;
    }
};
```
### 111. Minimum Depth of Binary Tree
-- Recursive: 左右；注意一边没有的情况
``` cpp
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        int dep = 1;
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        if(left == NULL){
            dep = 1 + minDepth(right);
        }
        else if(right == NULL){
            dep = 1 + minDepth(left);
        }
        else{
            dep = min(minDepth(left), minDepth(right)) + 1;
        }
        
        return dep;
    }
};
```
### 112. Path Sum
-- Recursive: 左or右，sum - root
``` cpp
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL){
            return false;
        }
        int rest = sum - root->val;
        TreeNode *left = root->left;
        TreeNode *right = root->right;
        if(root->val == sum && right == NULL && left == NULL){
            return true;
        }
        
        return hasPathSum(left, rest) || hasPathSum(right, rest);
    }
};
```
### 118. Pascal's Triangle
-- result[i][j]
``` cpp
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result(numRows);
        for(int i = 0; i < numRows; i++){
            result[i].resize(i + 1);
            result[i][0] = result[i][i] = 1;
            for(int j = 1; j < i; j++){
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }
        return result;
    }
};
```
### 119. Pascal's Triangle II
-- return the row of result[i][j]
``` cpp
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> result(rowIndex + 1);
        for(int i = 0; i < rowIndex + 1; i++){
            result[i].resize(i + 1);
            result[i][0] = result[i][i] = 1;
            for(int j = 1; j < i; j++){
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }
        return result[rowIndex];
    }
};
```
### 121. Best Time to Buy and Sell Stock
-- 找min，比较max和 当前 － 最小
``` java
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
```
### 122. Best Time to Buy and Sell Stock II
-- 只加增的
``` java
public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1]){
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
```
### 125. Valid Palindrome
-- isalnum(), tolower()
``` cpp
class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if (!isalnum(s[i])) {
                i++;
            }
            else if (!isalnum(s[j])){
                j--;
            }
            else {
                if (tolower(s[i++]) != tolower(s[j--])){
                    return false;   
                }
            }
        }
        return true;
    }
};
```
### 136. Single Number
-- ^= (bitwise XOR)
``` java
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res ^= n;
        }
        return res;
    }
}
```
### 141. Linked List Cycle
-- s->next == f->next->next
``` cpp
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* slow = head, *fast = head;
        while(slow && fast){
            slow = slow->next;
            if(fast->next == NULL) {
                return false;
            }
            fast = fast->next->next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
};
```
### 155. Min Stack

### 160. Intersection of Two Linked Lists
-- 逐一比较，null了则换到对面的head
``` cpp
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *a = headA, *b = headB;
        while (a != b){
            a = a?a->next:headB;
            b = b?b->next:headA;
        }
        return a;
    }
};
```
### 167. Two Sum II - Input array is sorted
-- 首尾相加比较
``` java
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length < 2){
            return res;
        }
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
            if(numbers[l] + numbers[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return res;
    }
}
```
### 168. Excel Sheet Column Title

### 169. Majority Element
-- sort -> middle one
``` java
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```
### 171. Excel Sheet Column Number

### 172. Factorial Trailing Zeroes
-- 有多少个5
``` cpp
class Solution {
public:
    int trailingZeroes(int n) {
        int res = 0;
        while(n){
            n /= 5;
            res += n;
        }
        return res;
    }
};
```
### 175. Combine Two Tables
-- left join
``` sql
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person 
LEFT JOIN Address on Person.PersonId = Address.PersonId;
```
### 176. Second Highest Salary
-- 小于max -> max
``` sql
SELECT Max(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT Max(Salary) FROM Employee)
```
### 181. Employees Earning More Than Their Managers
-- 2个自己table
``` sql
SELECT e1.Name as Employee
FROM Employee e1, Employee e2
WHERE e1.ManagerID = e2.ID && e1.Salary > e2.Salary
```
### 182. Duplicate Emails
-- Group by
``` sql
SELECT Email
FROM Person
GROUP BY Email
HAVING count(*) >1
```
### 183. Customers Who Never Order
-- left - inner <==> 被join的id = null
``` sql
SELECT Name as Customers
FROM Customers as c
LEFT JOIN Orders o
ON c.ID = o.CustomerID
Where o.id is null
```
### 191. Number of 1 Bits
-- &(bitwise and) -> n & n-1
``` java
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
```
### 196. Delete Duplicate Emails
-- Delete table from 2 tables
``` sql
DELETE p1
FROM Person p1, Person p2
WHERE p1.Id > p2.Id && p1.Email = p2.Email
```
### 197. Rising Temperature
-- DATEDIFF
``` sql
SELECT w1.ID
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.Date, w2.Date) = 1 && w1.Temperature > w2.Temperature
```
### 198. House Robber
-- max(带自己, 不带自己)
``` cpp
class Solution {
public:
    int rob(vector<int>& nums) {
        int l = nums.size();
        vector<int> result(l+1, 0);
        if(l == 0){
            return 0;
        }
        result[1] = nums[0];
        for(int i = 2; i < l+1; i++){
            result[i] = max(nums[i-1] + result[i-2], result[i-1]);
        }
        return result[l];
    }
};
```
### 202. Happy Number
-- Hashset to store 算过的数 避免循环
``` java
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10)*(n%10);
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
```
### 203. Remove Linked List Elements
-- p->next 和 val 比
``` cpp
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        if (head == NULL){
            return NULL;
        }
        ListNode* p = head;
        while(p->next != NULL){
            if (p->next->val == val){
                p->next = p->next->next;
            }
            else{
                p = p->next;
            }
        }
        if (head->val == val){
            head=head->next;
        }
        return head;
    }
};
```
### 205. Isomorphic Strings
-- char可做array的index！
``` c++
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int m1[256] = {0}, m2[256] = {0}, l = s.size();
        for (int i = 0; i < l; i++) {
            if (m1[s[i]] != m2[t[i]]){
                return false;  
            }
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        return true;
    }
};
```
### 217. Contains Duplicate
-- Set contains
``` java
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int num : nums){
            if(res.contains(num)){
                return true;
            }
            res.add(num);
        }
        return false;
    }
}
```
### 219. Contains Duplicate II
-- Map containsKey
``` java
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(nums[i]) && i - res.get(nums[i]) <= k){
                return true;
            }
            res.put(nums[i],i);
        }
        return false;
    }
}
```
### 226. Invert Binary Tree
-- Recursive: invert(left), invert(right)
``` cpp
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        TreeNode* res = root;
        invert(res);
        return root;
    }
    void invert(TreeNode* root) {
        TreeNode* res = root;
        if(res){
            TreeNode* temp = res->left;
            res->left = res->right;
            res->right = temp;
            invert(res->left);
            invert(res->right);
        }
    }
};
```
### 231. Power of Two
-- bit and: 2的指数都为1后面n个0
``` cpp
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return (n > 0) && !(n & (n - 1));
    }
};
```
### 234. Palindrome Linked List
-- 
``` cpp

```
### 237. Delete Node in a Linked List
-- next = 再下一个
``` java
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
### 242. Valid Anagram
-- char可做array的index！一加一减
``` java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] alph = new int[26];
        for(char ch : s.toCharArray()){
            alph[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            alph[ch - 'a']--;
            if(alph[ch - 'a'] < 0){
                return false; 
            } 
        }
        return true;
    }
}
```
### 263. Ugly Number
-- 除尽2、3、5
``` java
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        while(num % 2 == 0){
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 5 == 0){
            num /= 5;
        }
        if(num == 1){
            return true;
        }
        return false;
    }
}
```