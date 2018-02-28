//49. Group Anagrams
//Map<String, List<String>> map = new HashMap<>();

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
        	char[] letters = s.toCharArray();
        	Arrays.sort(letters);
        	String key = new String(letters);
        }
        if(map.containsKey(key)){
        	map.get(key).add(s);
        }else {
        	List<String> list = new ArrayList<>();
        	list.add(s);
        	map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}