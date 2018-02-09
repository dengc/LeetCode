//14. Longest Common Prefix
//if(index >= strs[i].size() || i > 0 && strs[i][index] != strs[i-1][index])

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = "";
        
        for(int index = 0; strs.size() > 0; index++){
        	for(int i = 0; i < strs.size(); i++){
        		if(index >= strs[i].size() || i > 0 && strs[i][index] != strs[i-1][index]){
        			return prefix;
        		}
        	}
        	prefix += strs[0][index];
        }
        return prefix;
    }
};