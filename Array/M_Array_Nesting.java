//565. Array Nesting
//set, 不contains就加1
//Medium
class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.clear();
            int count = 0;
            int a = nums[i];
            while(!set.contains(a)){
                set.add(a);
                a = nums[a];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}