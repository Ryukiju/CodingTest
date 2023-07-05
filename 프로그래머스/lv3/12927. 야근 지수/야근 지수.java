import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Arrays.sort(works);
        
        Stack<Long> stack = new Stack<>();
        Queue<Long> queue = new LinkedList<>();
        
        for(int i=0; i<works.length;i++) {
        	stack.add((long)works[i]);
        }
        
        while(n>0) {
        	//1.stack에서 하나씩 빼서 queue에 넣는다.
        	//2.stack에서 peek한게 같은지 보고 같으면 또빼고 아니면 그만뺀다
        	//3.peek한게 다르면 queue에있는거 peek한거랑 같아질때까지 1씩뺀다(n>0체크)
        	long work = stack.pop();
    		queue.add(work);
        	while(stack.size()>0) {
        		if(work==stack.peek()) {
        			queue.add(stack.pop());
        		}else {
        			break;
        		}
        	}
//        	System.out.println(queue);
        	while(!queue.isEmpty()) {
        		long q = queue.poll();
        		if(q==0) {
        			return 0;
        		}
        		if(n>0) {
            		q--;
            		n--;	
        		}
        		stack.add(q);
        	}
//        	System.out.println(queue);
        }
        
//        System.out.println(stack);
        while(!stack.isEmpty()) {
        	answer+=Math.pow(stack.pop(),2);
        }
        return answer;
    }
}