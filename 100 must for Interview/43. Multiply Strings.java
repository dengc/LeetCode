//43. Multiply Strings
//int[] num = new int[l1+l2]; 再按照位数 /10 or %10

class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] num = new int[l1+l2];

        for(int i = l1-1; i >=0; i--){
            for(int j = l2-1; j >=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + num[p2];
                num[p1] += sum / 10;
                num[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : num){
            if(!(sb.length() == 0 && n == 0)){
                sb.append(n);
            }
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}