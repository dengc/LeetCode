//38. Count and Say
//countAndSay(n - 1); StringBuilder; char[] arr

public class Solution {
    public String countAndSay(int n) {
        if(n <= 1){
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char cur = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(cur == arr[i]) {
                count++;
            } 
            else {
                sb.append(count);
                sb.append(cur);
                cur = arr[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
}