import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pLong = Long.valueOf(p);
        
        for(int i=0; i<t.length();i++) {
        	if(i+p.length()>t.length()) {
        		break;
        	}
        	if(Long.valueOf(t.substring(i, i+p.length()))<=pLong) {
        		answer++;
        	}
        }
        return answer;
    }
}