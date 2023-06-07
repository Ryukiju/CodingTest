import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answerSet = new HashSet<>();

        //시작 인덱스
        for(int i=0; i<=elements.length; i++) {
        	//수열 갯수
        	for(int j=1; j<=elements.length; j++) {
            	int summary = 0;
            	//수열 갯수만큼 summary
            	for(int x=0; x<j; x++) {
            		summary+=elements[(i+x)%elements.length];
            	}
            	answerSet.add(summary);
        	}
        }
        return answerSet.size();
    }
}