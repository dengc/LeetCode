//150. Evaluate Reverse Polish Notation
//stack add nums; 遇operator就pop 2 个数，然后运算，add

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a = 0, b = 0;
        for(String str : tokens){
            if(str.equals("+")){
                a = s.pop();
                b = s.pop();
                s.add(a + b);
            }else if (str.equals("-")) {
                a = s.pop();
                b = s.pop();
                s.add(b - a);
            }else if (str.equals("*")) {
                a = s.pop();
                b = s.pop();
                s.add(a * b);
            }else if (str.equals("/")) {
                a = s.pop();
                b = s.pop();
                s.add(b / a);
            }else {
                s.add(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}