import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<info> queue = new LinkedList<>();
        
        queue.add(new info(y,0));
        
        while(!queue.isEmpty()) {
        	info q = queue.poll();
        	
        	if(q.num == x) {
        		System.out.println(q.count);
        		return q.count;
        	}
        	if(q.num>x) {
        		if(q.num%3==0) {
            		queue.add(new info(q.num/3,q.count+1));
        		}
        		if(q.num%2==0) {
            		queue.add(new info(q.num/2,q.count+1));
                }
        		if(q.num-n>=x){
        			queue.add(new info(q.num-n,q.count+1));
        		}
        	}
        }
        return -1;
    }
}
    
class info{
	int num;
	int count;
	
	public info(int num, int count) {
		this.num = num;
		this.count = count;
	}
}