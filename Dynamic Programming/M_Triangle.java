//120. Triangle
//array: 每次加最小，list从下到上

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int l = triangle.size();
        int[] A = new int[l+1];
        for(int i = l-1; i>=0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}