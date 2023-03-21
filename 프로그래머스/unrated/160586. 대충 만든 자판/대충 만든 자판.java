import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		List<Integer> answerList = new ArrayList<>();
		
		int index = 0;
		for(String target: targets){
			int pressCnt=0;
			for(int i=0; i<target.length();i++) {
				List<Integer> pressCntList = new ArrayList<>();
				for(String key: keymap) {
					if(key.indexOf(target.charAt(i))>-1) {
						pressCntList.add(key.indexOf(target.charAt(i))+1);
					}
				}
				
				
				if(!pressCntList.isEmpty()) {
					pressCnt += Collections.min(pressCntList);
				}else {
					pressCnt = -1;
					break;
				}
				
			}
			// answerList.add(pressCnt);
			answer[index] = pressCnt;
			
			index++;
		}
		
		return answer;
    }
}