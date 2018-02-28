//56. Merge Intervals
//建立starts和ends array，然后排序

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int l = intervals.size();
        int[] starts = new int[l];
        int[] ends = new int[l];
        for(int i = 0; i < l; i++){
        	starts[i] = intervals.get(i).start;
        	ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res = new ArrayList<>();
        for(int i = 0, j = 0; i < l; i++){
        	if(i == l - 1 || starts[i + 1] > ends[i]){
        		res.add(new Interval(starts[j], ends[i]));
        		j = i + 1;
        	}
        }
        return res;
    }
}