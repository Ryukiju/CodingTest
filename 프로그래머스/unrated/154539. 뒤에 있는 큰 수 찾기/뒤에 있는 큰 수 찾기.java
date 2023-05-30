import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        //인덱스 저장
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers.length-1);
        answer[numbers.length-1] = -1;
        
        //뒤에서부터
        for(int i=numbers.length-2;i>=0;i--) {
        	int index = stack.peek();

        	if(numbers[i]<numbers[index]){
        		answer[i] = numbers[index];
        	}else {
        		while(!stack.isEmpty()&&numbers[stack.peek()]<=numbers[i]) {
        			stack.pop();
        		}
        		if(!stack.isEmpty()) {
        			answer[i] = numbers[stack.peek()];
        		}else {
        			answer[i] = -1;
        		}
        	}
    		stack.add(i);
        }
        
        return answer;
    }
}