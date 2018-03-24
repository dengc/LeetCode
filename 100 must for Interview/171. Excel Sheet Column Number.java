//171. Excel Sheet Column Number
//根据s长度，每多一个，*26，然后当位 -'A'+1

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res *= 26;
            res += (s.charAt(i) - 'A') + 1;
        }
        return res;
    }
}