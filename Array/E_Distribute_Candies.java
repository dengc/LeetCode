//575. Distribute Candies
//到没到一半unique

class Solution {
    public int distributeCandies(int[] candies) {
        int l = candies.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int n : candies){
            set.add(n);
        }
        int res = set.size();
        return Math.min(res, l/2);
    }
}