import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        // System.out.println(map);
        
        for(Entry<String, Integer> entrySet : map.entrySet()) {
        	answer*= entrySet.getValue()+1;
        }
        
        return answer-1;
    }
}