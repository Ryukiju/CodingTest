import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        int index = 0;
        for(String privacy:privacies) {
        	int privacyDay = calculateDay(privacy.split(" ")[0]);
        	String privacyType = privacy.split(" ")[1];
        	for(String term:terms) {
        		String termType =term.split(" ")[0]; 
        		int termDay = Integer.parseInt(term.split(" ")[1])*28;
        		
        		if(privacyType.equals(termType)&&(privacyDay+termDay)<=calculateDay(today)) {
        			answerList.add(index+1);
        		}
        	}
        	index++;
        }
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size();i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	
	public static int calculateDay(String dateString) {
		String[] daySplit = dateString.split("\\.");
		int yyDay = Integer.parseInt(daySplit[0])*28*12;
		int mmDay = Integer.parseInt(daySplit[1])*28;
		int ddDay = Integer.parseInt(daySplit[2]);
		return yyDay+mmDay+ddDay;
	}
	
}