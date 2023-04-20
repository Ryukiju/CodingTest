import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        List<Integer[]> answerList = new ArrayList<>();
        
        int start=0;
        int end = 0;
        
        int sum = sequence[0];
        while(start!=sequence.length) {
        	
        	if(sum==k) {
        		Integer[] ele = {start, end}; 
        		answerList.add(ele);
//        		System.out.println(start+" "+end);
        		
        		if(end+1==sequence.length) {
        			sum-=sequence[start];
        			start++;
        		}else {
        			end++;
        			sum+=sequence[end];
        		}
        	}else if(sum>k) {
    			sum-=sequence[start];
        		start++;
        	}else {
        		if(end+1==sequence.length) {
        			if(start+1<sequence.length) {
        				sum-=sequence[start];
                		start++;
        			}else {
        				break;
        			}
        			
        		}else {
            		end++;
        			sum+=sequence[end];
        		}
        	}
        	
        }
        
        answer[0] = answerList.get(0)[0];
        answer[1] = answerList.get(0)[1];
        
        int chaie = answer[1]-answer[0];
        
        for(Integer[] ans:answerList) {
        	int chaie2 = ans[1]-ans[0];
        	if(chaie2<chaie) {
        		answer[0] = ans[0];
        		answer[1] = ans[1];
        		chaie = chaie2;
        	}
        }
        
        return answer;
    }
}