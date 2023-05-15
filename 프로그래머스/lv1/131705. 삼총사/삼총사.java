class Solution {
    public static int solution(int[] number) {
        int answer = 0;
        
        for(int one=0; one<number.length; one++) {
        	for(int two=one+1; two<number.length; two++) {
        		for(int three=two+1; three<number.length; three++) {
                	if(number[one]+number[two]+number[three]==0) {
                		answer++;
                	}
                }
            }
        }
        
        
        return answer;
    }
}