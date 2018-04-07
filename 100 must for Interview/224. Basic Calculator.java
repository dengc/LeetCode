//224. Basic Calculator
//sign: "+"为1，"-"为-1；stack:遇到"(" push res 和 sign, 再归零

class Solution {
    public int calculate(String s) {
    	int res = 0;
    	char[] ch = s.toCharArray();  
    	int l = s.length();
   		int sign = 1;
   		Stack<Integer> stack = new Stack<>();
   		for(int i = 0; i < l; i++){
   			if(Character.isDigit(ch[i])){
   				int num = Character.getNumericValue(ch[i]);
   				while(i+1 < l && Character.isDigit(ch[i+1])){
   					num = num * 10 + Character.getNumericValue(ch[i+1]);
   					i++;
   				}
   				res += sign * num;
   			}
   			else if (ch[i] == '+'){
   				sign = 1;
   			}
   			else if (ch[i] == '-') {
   				sign = -1;
   			}
   			else if (ch[i] == '(') {
   				stack.push(res);
   				stack.push(sign);
   				res = 0;
   				sign = 1;
   			}
   			else if (ch[i] == ')') {
   				res = res * stack.pop() + stack.pop();
   			}
   		}
    	return res;
    }
}