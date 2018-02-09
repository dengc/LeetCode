//17. Letter Combinations of a Phone Number
//LinkedList: FIFO -- remove

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()){
        	return res;
        }
        res.add("");
		String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		for(int i = 0; i < digits.length(); i++){
			int num = Character.getNumericValue(digits.charAt(i));
			while(res.peek().length() == i){
				String before = res.remove();
				for(Char now : keys[num].toCharArray()){
					res.add(before + now);
				}
			}
		}
		return res;
    }
}