//139. Word Break
//boolean[l+1]: 一段true？false

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] flags = new boolean[l + 1];
        flags[0] = true;
        for(int i = 1; i <= l; i++){
            for(int j = 0; j < i; j++){
                if(flags[j] && wordDict.contains(s.substring(j, i))){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[l];
    }
}