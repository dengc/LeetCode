//179. Largest Number
//new class stringCompare, compare str1+str2 和 str2+str1; sort string array

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "0";
        }
        String[] num = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, new stringCompare());
        //[0,0] => 00
        if(num[0].charAt(0) == '0'){
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for(String str : num){
            res.append(str);
        }
        return res.toString();
    }
}
class stringCompare implements Comparator<String>{
    @Override
    public int compare(String str1, String str2){
        String s1 = str1 + str2;
        String s2 = str2 + str1;

        return s2.compareTo(s1);
    }
}