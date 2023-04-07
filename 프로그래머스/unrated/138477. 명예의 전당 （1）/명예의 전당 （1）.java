import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> award = new ArrayList<>();

        for(int i=0; i<score.length;i++) {
        	
        	if(award.size()<k) {
        		award.add(score[i]);
        	}else {
        		if(award.get(0)<score[i]) {
        			award.remove(0);
        			award.add(score[i]);
        		}
        	}
        	
        	Collections.sort(award);

        	int minAward = award.get(0);
        	for(int j=0; j<award.size();j++) {
        		minAward = Math.min(minAward, award.get(j));
        	}
        	answer[i] = minAward;
        }
        
        
        return answer;
    }
}