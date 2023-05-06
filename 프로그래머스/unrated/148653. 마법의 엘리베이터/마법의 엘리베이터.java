class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0) {
        	int num = storey%10;
        	
        	if(num>5) {
            	answer+=(10-num);
            	storey=storey/10+1;
        	}else if(num == 5) {
            	answer+=(10-num);
        		if((storey/10)%10>=5) {
        			storey=storey/10+1;
        		}else {
        			storey=storey/10;
        		}
        		
        	}else {
            	answer+=num;
            	storey=storey/10;
        	}
        }
        return answer;
    }
}