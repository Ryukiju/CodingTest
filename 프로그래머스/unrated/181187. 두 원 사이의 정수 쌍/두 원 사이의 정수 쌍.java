class Solution {
	public long solution(int r1, int r2) {
		long answer = 0;

		for(long i=1; i<=r2;i++) {
			long minY;
			long maxY;
			
			maxY = (long) Math.floor(Math.sqrt((long)r2*(long)r2-i*i));
			minY = (long) Math.ceil(Math.sqrt((long)r1*(long)r1-i*i));
			
			answer+=maxY-minY+1;
//			System.out.println("maxY :"+maxY+", minY :"+minY);
			
		}
		
//		answer-=r2-r1+1;
		answer*=4;
		
		return answer;
	}
	
	
	public static double calcLine(int x, int y) {
		return Math.sqrt(x*x+y*y);
	}
}