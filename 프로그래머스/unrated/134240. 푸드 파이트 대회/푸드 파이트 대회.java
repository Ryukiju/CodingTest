class Solution {
    public String solution(int[] food) {
        StringBuffer answer = new StringBuffer("");
        StringBuffer sb = new StringBuffer("");
        
        for(int num=0; num<food.length;num++) {
        	int foodCnt = food[num]/2;
        	if(foodCnt>0) {
        		for(int i=0; i<foodCnt;i++) {
        			sb.append(num);
        		}
        	}
        }
        
        answer.append(sb.toString());
        answer.append(0);
        answer.append(sb.reverse());
        
//        System.out.println(answer);
        return answer.toString();
    }
}