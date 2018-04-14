//454. 4Sum II
//Map: <每一个A和B的数字之和, 数量>; 再看C和D之和，每次加map数量

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = A.length;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                int sum = 0 - C[i] - D[j];
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}