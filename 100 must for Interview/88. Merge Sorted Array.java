//88. Merge Sorted Array
//从右往左比较，大的填入A[]

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1 ;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            if(A[m] > B[n]){
                A[index--] = A[m--] ;
            }else{
                A[index--] = B[n--] ;
            }
        }
        while(n >= 0){
            A[index--] = B[n--] ;
        }
    }
}
