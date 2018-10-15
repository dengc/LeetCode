# 刷题

@(IT Studies)


-------------------

[TOC]

## Types
-------------------
### String
<i>842. Split Array into Fibonacci Sequence

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

#### Parentheses
<i>20. Valid Parentheses
- do while loop -> str.replace
- stack

<i>856. Score of Parentheses
- stack: s[-1]为’(’ 装1，否则sum += s.pop()

### Subsequence
<i>128. Longest Consecutive Sequence
- Set: for every num while num++ and num— 在不在set里

<i>792. Number of Matching Subsequences
- 对于每一个char, index在前一个char的后面：index = s.find(char, index+1)

### Substring
<i>3. Longest Substring Without Repeating Characters
- Set: remove char from head of string

<i>844. Backspace String Compare
- 建新string res：遇到’#’, 删去最后一个char -> res = res[:len(res) - 1]