//347. Top K Frequent Elements
//sort array, 建立array of arraylist => new List[l+1]; 在index为count里add相应num

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int l = nums.length;
        List<Integer>[] countIndex = new List[l+1];
        for (int i = 0; i < l+1; i++) {
            countIndex[i] = new ArrayList<>();
        }
        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < l-1; i++){
            if(nums[i] == nums[i+1]){
                count++;
            }else {
                countIndex[count].add(nums[i]);
                count = 1;
            }
        }
        countIndex[count].add(nums[l-1]);
        for(int i = l; i >= 0; i--){
            if(countIndex[i].size() > 0){
                for(int n : countIndex[i]){
                    if(res.size() < k){
                        res.add(n);
                    }
                }
            }
        }
        return res;
    }
}