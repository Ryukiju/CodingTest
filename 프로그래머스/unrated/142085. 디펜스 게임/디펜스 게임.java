import java.util.*;

class Solution {
	public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return - Integer.compare(o1, o2);
        	}
		});
        
        
        for(int enemyCnt:enemy) {
        	pq.add(enemyCnt);
    		
    		
        	n-=enemyCnt;
    		answer++;
    		
        	if(n<0&&k>0) {
        		n+=pq.poll();
        		k--;
        		
        	}else if(n<0&&k<=0){
        		answer--;
        		return answer;
        	}
        }
        
        return answer;
    }
}
