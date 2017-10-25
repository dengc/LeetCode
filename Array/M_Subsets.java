//78. Subsets
//Recursive: 上一个的所有 + 最后一个value
//Medium
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> newList = new ArrayList<Integer>();
        int l = nums.length;
        if(l == 0){
            res.add(list);
            return res;
        }
        if(l == 1){
            res.add(list);
            newList.add(nums[0]);
            res.add(newList);
            return res;
        }
        List<List<Integer>> lastRes = new ArrayList<List<Integer>>();
        int[] lastNums = new int[l-1];
        for(int i = 0; i < l -1; i++){
            lastNums[i] = nums[i];
        }
        lastRes = subsets(lastNums);
        int toAdd = nums[l-1];
        for(int i = 0; i < lastRes.size(); i++){
            list = lastRes.get(i);
            res.add(list);
            newList = new ArrayList<>(list);
            newList.add(toAdd);
            res.add(newList);
        }
        return res;
    }
}