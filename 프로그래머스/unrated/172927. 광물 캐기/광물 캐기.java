import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
		Integer minEffort = Integer.MAX_VALUE;
		
		Queue<info> q = new LinkedList<>();
		
		q.add(new info(picks,minerals,0,0));
		while(!q.isEmpty()) {
			info in = q.poll();
			
			if(in.pos>minerals.length) {
				minEffort = Math.min(minEffort,in.effort);
			}
			
			if(in.picks[0]==0&&in.picks[1]==0&&in.picks[2]==0) {
				minEffort = Math.min(minEffort,in.effort);
			}
			
			for(int i=0; i<3;i++) {
				if(in.picks[i]==0) {
					continue;
				}
				
				
				int qEffort = in.effort;
				for(int j=0; j<Math.min(5, minerals.length-in.pos);j++) {
					if(i==0) {
						qEffort+=1;
					}
					if(i==1) {
						if(minerals[j+in.pos].equals("diamond")) {
							qEffort+=5;
						}else {
							qEffort+=1;
						}
					}
					if(i==2) {
						if(minerals[j+in.pos].equals("diamond")) {
							qEffort+=25;
						}else if(minerals[j+in.pos].equals("iron")){
							qEffort+=5;
						}else {
							qEffort+=1;
						}
					}
				}
				
				int[] copyPicks= in.picks.clone();
				copyPicks[i]--;
				
				q.add(new info(copyPicks,minerals,in.pos+5,qEffort));
			}
			
		}
		return minEffort;
	}
}

class info {
	int[] picks;
	String[] minerals;
	int pos;
	int effort ;
	
	public info(int[] picks, String[] minerals, int pos, int effort) {
		this.picks = picks;
		this.minerals = minerals;
		this.pos = pos;
		this.effort = effort;
	}
}