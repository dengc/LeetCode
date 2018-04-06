//207. Course Schedule
//左边数为noTake set, 剩下的为take ArrayList, 与右边数一一对应, 合格的数放进list

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int l = prerequisites.length;
        Set<Integer> noTake = new HashSet<>();
        for(int i = 0; i < l; i++){
        	noTake.add(prerequisites[i][0]);
        }
        ArrayList<Integer> take = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
        	if(!noTake.contains(i)){
        		take.add(i);
        	}
        }
        for(int i = 0; i < take.size(); i++){
        	int taking = take.get(i);
        	for(int j = 0; j < l; j++){
        		int willTake = prerequisites[j][0];
        		if(taking == prerequisites[j][1] && noTake.contains(willTake)){
        			for(int k = 0; k < l; k++){
        				if(prerequisites[k][0] == willTake && noTake.contains(prerequisites[k][1])){
        					break;
        				}
                        if(k == l-1){
                            take.add(willTake);
        				    noTake.remove(willTake);
                        }
        				
        			}
        		}
        	}
        }
        return (take.size() == numCourses) || (l == 0);
    }
}