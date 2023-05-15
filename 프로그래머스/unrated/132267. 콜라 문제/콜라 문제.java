class Solution {
    public static int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a) {
        	//몫
        	int mog = n/a;
        	//나머지
        	int namerge = n%a;
        	System.out.println("몫 :"+mog+", 나머지 :"+namerge);
        	answer+=mog*b;
        	n = mog*b+namerge;
        }
        
        return answer;
    }
}