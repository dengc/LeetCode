//592. Fraction Addition and Subtraction
//

class Solution {
    public String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0) {
            return "0/1";
        }
        int a = 0;
        int b = 1;
        int k = 0;
        int[] temp = null;
        while (k < expression.length()) {
            temp = getNextInt(expression, k);
            int c = temp[0];
            temp = getNextInt(expression, temp[1]);
            int d = temp[0];
            k = temp[1];
            a = a * d + c * b;
            b *= d;
            int gcd = gcd(Math.abs(a), Math.abs(b));
            a /= gcd;
            b /= gcd;
        }
        return a + "/" + b;
    }
    
    int[] getNextInt(String s, int k) {
        int pos = s.charAt(k) == '-' ? -1 : 1;
        while (k < s.length() && (s.charAt(k) < '0' || s.charAt(k) > '9')) {
            k++;
        }
        int x = 0;
        while (k < s.length() &&  s.charAt(k) >= '0' && s.charAt(k) <= '9') {
            x = x * 10 + (s.charAt(k) - '0');
            k++;
        }
        return new int[]{pos * x,  k};
    }
    
    int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}