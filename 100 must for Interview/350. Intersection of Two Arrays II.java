//350. Intersection of Two Arrays II
//Map:每个数有多少个

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                arrList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++){
            res[i] = arrList.get(i);
        }
        return res;
    }
}