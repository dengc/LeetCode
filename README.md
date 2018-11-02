# 刷题

@(IT Studies)


-------------------

[TOC]

## Types
-------------------
### String
<i>816. Ambiguous Coordinates
- compare S[i] 和 w[j], 不等的话看S[i] 和S[i-1]以及S[i+1]是否等；或看S[i] 和S[i-1]以及S[i-2]

<i>916. Word Subsets
- collections.Counter()

<i>859. Buddy Strings
- 防止出现A = B但A里面有duplicate letters：’aa'

<i>893. Groups of Special-Equivalent Strings
- 对于每一个str：奇和偶分别建new arr[26], 记录字母数量，然后合并后放进set

<i>890. Find and Replace Pattern
- 建立map 比较char；set for value

<i>848. Shifting Letters
- 用ord(char) 和 chr(int); %26 防止超大数

<i>833. Find And Replace in String
- 根据targets[i] 和 sources[i]长度diff，改变indexes里的index，仅改变更大的index

<i> 824. Goat Latin
- word += 'a' *(i+1) 用乘法不用loop

<i> 816. Ambiguous Coordinates
- 看一个数，return其可能的list：if首char为0；最后一个char为0

<i>767. Reorganize String
- 先按count sort S, 前一半char放在奇数index上(a[1::2]), 后一半放偶数index上(a[::2])

#### Palindromic
<i>5. Longest Palindromic Substring
- 判断isPalindrome(s, i-currLength-1, i) 还是 isPalindrome(s, i-currLength, i)

<i> 647. Palindromic Substrings
- 从头到尾以此判断 s == s[::-1] (O(n^2))
- 
#### Parentheses
<i>20. Valid Parentheses
- do while loop -> str.replace
- stack

<i>856. Score of Parentheses
- stack: s[-1]为’(’ 装1，否则sum += s.pop()

<i>678. Valid Parenthesis String
- 2 stacks: 第一个从左往右装，遇到 ')' 就pop; 第二个从右往左装，遇到 '(' 就pop

#### Subsequence
<i>128. Longest Consecutive Sequence
- Set: for every num while num++ and num— 在不在set里

<i>792. Number of Matching Subsequences
- 对于每一个char, index在前一个char的后面：index = s.find(char, index+1)

#### Substring
<i>3. Longest Substring Without Repeating Characters
- Set: remove char from head of string

<i>844. Backspace String Compare
- 建新string res：遇到’#’, 删去最后一个char -> res = res[:len(res) - 1]

### Linked List
<i> 2. Add Two Numbers
- recursive

<i>21. Merge Two Sorted Lists
- recursive: 小的list->next = mergeTwoLists(小的list->next, 另一个list)     

<i>23. Merge k Sorted Lists
- 用mergeTwoLists，直到只有一个list

<i>82. Remove Duplicates from Sorted List II
- 在head前建个ListNode(0)连接head；对于每一个val，比较自己和next

<i>141. Linked List Cycle
- slow = next; fast = next.next; 看能不能有一刻 slow = fast

<i>160. Intersection of Two Linked Lists
- 分别从头next, 到null后换到另外的head持续next，直到相遇

### Tree
<i>116. Populating Next Right Pointers in Each Node
- 先连left & right, 如果有next, 连right & next.left; 逐层往下
- 
<i>124. Binary Tree Maximum Path Sum
- subPath: sub左&右; res = val + 左 + 右; return val + max(左，右）

<i>145. Binary Tree Postorder Traversal
- stack放root, pop; insert在arr最前；stack放左，放右

<i>94. Binary Tree Inorder Traversal
- inorder(左)；arr.append(自己)；inorder(右)

<i>230. Kth Smallest Element in a BST
- BST变sorted list: inorder

<i>114. Flatten Binary Tree to Linked List
- flat(左), flat(右)；把left放右边，把right放left右边

<i>102. Binary Tree Level Order Traversal
- 2D list: res[depth].append(val); build(左, d+1), build(右, d+1)

<i>103. Binary Tree Zigzag Level Order Traversal
- same as 102, if depth是奇数，insert头；偶数就append

<i>104. Maximum Depth of Binary Tree
- max(maxDepth(root->left), maxDepth(root->right)) + 1

<i>108. Convert Sorted Array to Binary Search Tree
- mid处建new tree；mid左（nums,low, mid-1），mid右（nums,mid+1,high）

### Array
<i>66. Plus One
- 从后往前，while 是9就让其等于0

<i>134. Gas Station
- 对于每个数，sum(gas - cost)，若<0, 则从下一站开始

<i>55. Jump Game
- 对于每个数，自己最远距离dis = i+ nums[i], 此前一共f = max(f, dis)
<i>56. Merge Intervals
- 建2个array，分别sort start[] 和 end[]; 比较start[i]和end[i-1]比较，变化start里的数

#### max & min
<i>53. Maximum Subarray
- 对于每个数，加进sum; 取max; 若sum为负，令sum = 0

<i>152. Maximum Product Subarray
- 对于每个数：算出带上自己的max和min; res = max(res,max)

<i>121. Best Time to Buy and Sell Stock
- 对于每个数：min = min(min, 自己)； max = max(max, 自己 - min)

<i>122. Best Time to Buy and Sell Stock II
- 如果后一个数大，则减去前一个数

<i>123. Best Time to Buy and Sell Stock III
- 借用121，而后 min2 = min(min2, 自己 - max1)

<i>188. Best Time to Buy and Sell Stock IV

<i>84. Largest Rectangle in Histogram

#### Sort
<i>4. Median of Two Sorted Arrays
- merge into a new sorted array

<i>88. Merge Sorted Array
- 从大到小insert，index = m + n - 1 开始

### 2D Array
<i>54. Spiral Matrix
- 分别4个for loop: 右下左上

### 应用题
<i>11. Container With Most Water
- right & left: 两头往中间并

<i>17. Letter Combinations of a Phone Number
<i>12. Integer to Roman
<i>13. Roman to Integer
<i>118. Pascal's Triangle
<i>119. Pascal's Triangle II
<i>149. Max Points on a Line
<i>174. Dungeon Game

## Methods
-------------------
### DP
<i>72. Edit Distance
- 建new 2D：数字，看左上、左、上

<i>91. Decode Ways
- 建new arr[]: 遇0放0，从右往左，memo[i] = memo[i+1]+memo[i+2] 或 memo[i] = memo[i+1];

### Two Pointers (一头一尾...)
<i>11. Container With Most Water
<i>15. 3Sum

### dictionary/hashmap
<i>1. Two Sum
<i>49. Group Anagrams
- key为sort后的每个str; value为list: 每个对应key的str

<i>791. Custom Sort String
- key为S的char; value为其对应index：在res中比较dic[t] 和 dic[res[index]]

<i>609. Find Duplicate File in System
- key 为content = p[p.find('(', i):p.find(')', i)+1]; value为其对应path

### Queue - FIFO
<i>17. Letter Combinations of a Phone Number

### Stack
<i>150. Evaluate Reverse Polish Notation
<i>145. Binary Tree Postorder Traversal
- stack放root, pop; insert在arr最前；stack放左，放右

### swap
<i>41. First Missing Positive
- while每个地方数: swap到他相对应的index上


## 其他
-------------------
厉害了：22，29，31，39, 43, 493， 105，72, 174，84, 842，722