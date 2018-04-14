//387. First Unique Character in a String
//new int[26]: arr[ch - 'a']++;

class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch) {
            arr[c - 'a']++;
        }
        for(int i = 0; i < ch.length; i++) {
            if(arr[ch[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;   
    }
}