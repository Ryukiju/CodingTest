import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int same = 0;
        int diff = 0;
        
        Character first=null;
        for(int i=0; i<s.length();i++) {

        	if(same==diff) {
        		answer++;
        		first=s.charAt(i);
        	}
        	
        	if(s.charAt(i)==first) {
        		same++;
        	}else {
        		diff++;
        	}
        }
        return answer;
    }
}