import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int end = -1;
        
        for(int[] target: targets) {
//        	System.out.println(target[0]+","+target[1]);
        	int start = target[0];
        	if(end<=start) {
        		answer++;
        		end = target[1];
        		System.out.println(target[0]+", "+target[1]);
        	}
        	
        	
        }
        
        
        return answer;
    }
}