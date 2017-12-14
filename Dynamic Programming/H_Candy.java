//135. Candy
//从左往右array & 从右往左array

class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        if(l <= 1){
            return l;
        }
        int res = 0;
        int[] left = new int[l];
        int[] right = new int[l];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 0; i < l-1; i++){
            if(ratings[i+1] > ratings[i]){
                left[i+1] = left[i] + 1;
            }
        }
        for(int i = l-1; i > 0; i--){
            if(ratings[i-1] > ratings[i]){
                right[i-1] = right[i] + 1;
            }
        }
        for(int i = 0; i < l; i++){
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}