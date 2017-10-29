//495. Teemo Attacking
//差值和duration比较
//Medium
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int l = timeSeries.length;
        int count = 0;
        if(l == 0){
            return 0;
        }
        for(int i = 1; i < l; i++){
            int diff = timeSeries[i] - timeSeries[i-1];
            if(diff < duration){
                count += diff;
            }else {
                count += duration;
            }
        }
        count += duration;
        return count;
    }
}