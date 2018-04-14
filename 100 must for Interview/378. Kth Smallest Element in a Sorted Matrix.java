//378. Kth Smallest Element in a Sorted Matrix
//new int[]: 装每行第几列为下一个要比较的数; 每次比较matrix[i][row[i]]

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix.length;
        int[] row = new int[l];
        row[0] = 1;
        int count = 1;
        int res = matrix[0][0];
        while(count < k){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < l; i++){
                if(row[i] < l && matrix[i][row[i]] < min){
                    index = i;
                    min = matrix[i][row[i]];
                }
            }
            count++
            row[index]++;
            res = min;
        }
        return res;
    }
}