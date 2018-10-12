# 刷题

@(IT Studies)


-------------------

[TOC]

## Types
-------------------
### String
#### 842. Split Array into Fibonacci Sequence
#### 916. Word Subsets
- collections.Counter()
#### 859. Buddy Strings
- 防止出现A = B但A里面有duplicate letters：’aa'
#### 893. Groups of Special-Equivalent Strings
- 对于每一个str：奇和偶分别建new arr[26], 记录字母数量，然后合并后放进set
#### 890. Find and Replace Pattern
- 建立map 比较char；set for value
#### 848. Shifting Letters
- 用ord(char) 和 chr(int); %26 防止超大数
#### 833. Find And Replace in String
- 根据targets[i] 和 sources[i]长度diff，改变indexes里的index，仅改变更大的index
#### Parentheses
##### 20. Valid Parentheses
- do while loop -> str.replace
- stack
##### 856. Score of Parentheses
- stack: s[-1]为’(’ 装1，否则sum += s.pop()
