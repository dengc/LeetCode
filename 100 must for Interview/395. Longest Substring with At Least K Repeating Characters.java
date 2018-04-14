//395. Longest Substring with At Least K Repeating Characters
//new int[26]: arr[ch - 'a']++; ArrayList记录下字母数小于k的位置，逐段longestSubstring (recursive)

class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int[] arr = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch) {
            arr[c - 'a']++;
        }
        ArrayList<Integer> bad = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(arr[ch[i] - 'a'] < k){
                bad.add(i);
            }
        }
        if(bad.size() == 0){
            return s.length();
        }
        bad.add(0, -1);
        bad.add(s.length());
        for(int i = 1; i < bad.size(); i++){
            int start = bad.get(i-1) + 1;
            int end = bad.get(i);
            res = Math.max(res, longestSubstring(s.substring(start, end), k));
        }
        return res;   
    }
}