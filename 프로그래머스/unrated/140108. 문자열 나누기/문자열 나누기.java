import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int same = 1;
        int diff = 0;
        
        char first = s.charAt(0);
        for(int i=1; i<s.length();i++) {

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
        
        System.out.println(answer);
        return answer+1;
    }
}