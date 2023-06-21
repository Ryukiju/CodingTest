class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuffer answer = new StringBuffer();
        
        int count=0;
        StringBuffer sb = new StringBuffer();

        while(answer.length()<t) {
        	while(sb.length()<m) {
        		sb.append(Integer.toString(count, n));
        		count++;
        	}
        	answer.append(sb.substring(p-1,p).toUpperCase());
        	sb.delete(0, m);
        }
        
        return answer.toString();
    }
}