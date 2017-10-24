//560. Subarray Sum Equals K
//map: storing continuing sum with counts
//Medium
public int subarraySum(int[] nums, int k) {
    if(nums == null || nums.length == 0){
        return 0;
    }
    int result = 0;
    Map<Integer, Integer> continuingSum = new HashMap<>();
    int sum = 0;
    continuingSum.put(0, 1);
    for(int i = 0; i < nums.length; i++){
        sum += nums[i];
        if(continuingSum.containsKey(sum - k)){
            result += continuingSum.get(sum - k);
        }
        continuingSum.put(sum, continuingSum.getOrDefault(sum, 0) + 1);
    }
    return result;
}