class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s) {
        	int[] ans = new int[1];
        	ans[0] = -1;
        	return ans;
        }
        
        int mog = s/n;
        int namerge = s%n;
        
        for(int i= answer.length-1; i>=0; i--) {
        	if(namerge>0) {
        		answer[i]= mog+1;
        		namerge--;
        	}else {
        		answer[i]= mog;
        	}
        }
        
        return answer;
    }
}