import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int ingredien: ingredient) {
        	list.add(ingredien);
        }
        
        for(int i=0; i<list.size();i++) {
        	
        	if(list.get(i)==1&&list.size()>i+3) {
        		if(list.get(i+1)==2) {
        			if(list.get(i+2)==3) {
        				if(list.get(i+3)==1) {
        					list.remove(i+3);
        					list.remove(i+2);
        					list.remove(i+1);
        					list.remove(i);
        					answer++;
        					if(i-4>=0) {
        						i-=4;
        					}else {
        						i=-1;
        					}
        				}
        			}
        		}
        	}
        	
        }
        
        return answer;
    }
}