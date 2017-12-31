//264. Ugly Number II
//index2,3,5

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        int ind2 = 1;
        int ind3 = 1;
        int ind5 = 1;
        for(int i = 2; i < n+1; i++){
            arr[i] = Math.min(2*arr[ind2], 3*arr[ind3], 5*arr[ind5]);
            if(arr[i] == 2*arr[ind2]){
                ind2++;
            }
            if(arr[i] == 3*arr[ind3]){
                ind3++;
            }
            if(arr[i] == 5*arr[ind5]){
                ind5++;
            }
        }
        return arr[n];
    }
}