//227. Basic Calculator II
//sign 记录 +-*/, 每次stack.push新num（如除法则：push stack.pop() / num）

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int res = 0;
        int num = 0;
        char sign = '+';
        for(int i = 0; i < ch.length; i++) {
        	if(Character.isDigit(ch[i])){
        		num = num * 10 + Character.getNumericValue(ch[i]);
        	}
        	if(i == ch.length - 1 || !Character.isDigit(ch[i]) && ch[i] != ' '){
        		if(sign == '+'){
        			stack.push(num);
        		}
        		else if (sign == '-') {
        			stack.push(-num);
        		}
        		else if (sign == '*'){
        			stack.push(stack.pop() * num);
        		}
        		else if (sign == '/') {
        			stack.push(stack.pop() / num);
        		}
        		num = 0;
        		sign = ch[i];
        	}
        }
        for(int n : stack){
        	res += n;
        }
        return res;
    }
}