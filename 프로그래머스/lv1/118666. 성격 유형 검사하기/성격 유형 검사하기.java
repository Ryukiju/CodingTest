import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        StringBuffer answer = new StringBuffer();
        
        Character[] leftList = {'R','C','J','A'};
        Character[] rightList = {'T','F','M','N'};
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<choices.length; i++) {
        	
        	if(choices[i]>4) {
        		map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1),0)+(choices[i]-4));
        	}else if(choices[i]<4) {
        		map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0),0)+(4-choices[i]));
        	}
        	
        }
        
        for(int i=0; i<leftList.length;i++) {
        	if(map.getOrDefault(leftList[i],0)==map.getOrDefault(rightList[i],0)) {
        		if(leftList[i]<rightList[i]) {
        			answer.append(leftList[i]);
        		}else {
        			answer.append(rightList[i]);
        		}
        		
        	}else if(map.getOrDefault(leftList[i],0)>map.getOrDefault(rightList[i],0)) {
        		answer.append(leftList[i]);
        	}else {
        		answer.append(rightList[i]);
        	}
        }
        
        return answer.toString();
    }
}