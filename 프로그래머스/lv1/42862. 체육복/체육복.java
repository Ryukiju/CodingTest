import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        List<Integer> lostAndReserve = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if(lost[i]==reserve[j]) {
        			lost[i]=-1;
        			reserve[j]=-5;
        			answer++;
        			break;
        		}
        	}
        }
        
        int lostIndex = 0;
        int reserveIndex = 0;
        
        while(lostIndex<lost.length&&reserveIndex<reserve.length) {
//        	System.out.println("lostIndex :"+lostIndex+", reserveIndex :"+reserveIndex);
//        	if(lostAndReserve.contains(lost[lostIndex])) {
//        		answer++;
//        		lostIndex++;
//        		continue;
//        	}
//        	if(lostAndReserve.contains(reserve[reserveIndex])) {
//        		reserveIndex++;
//        		continue;
//        	}

        	if(lost[lostIndex]-1<=reserve[reserveIndex]&&lost[lostIndex]+1>=reserve[reserveIndex]) {
        		reserveIndex++;
        		answer++;
        		lostIndex++;
        	}else if(lost[lostIndex]<reserve[reserveIndex]){
        		lostIndex++;
        	}else{
        		reserveIndex++;
        	}
        }
        return answer;
    }
}