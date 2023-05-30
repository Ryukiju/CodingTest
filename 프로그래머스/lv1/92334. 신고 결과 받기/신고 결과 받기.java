import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //신고당한사람 : 신고한사람리스트
        Map<String, List<String>> banUserMap = new HashMap<>(); 
        
        //메일 받는 횟수
        Map<String, Integer> mailCntMap = new HashMap<>();
        
        
        for(int i=0; i<report.length;i++) {
        	String username = report[i].split(" ")[0];
        	String banUsername = report[i].split(" ")[1];
        	
        	if(banUserMap.get(banUsername)==null) {
        		//신고당한사람 : 신고한사람 등록
        		List<String> banUserList = new ArrayList<>();
        		banUserList.add(username);
        		banUserMap.put(banUsername,banUserList);
        		
        	}else {
        		List<String> banUserList = banUserMap.get(banUsername);
        		if(!banUserList.contains(username)) {
        			banUserList.add(username);
        		}
        		banUserMap.put(banUsername,banUserList);
        	}
        }

		for(Entry<String, List<String>> entry : banUserMap.entrySet()) {
			if(entry.getValue().size()>=k) {
				for(String username : entry.getValue()) {
					mailCntMap.put(username,mailCntMap.getOrDefault(username, 0)+1);
				}
			}
		}
        
        for(int i=0; i<id_list.length;i++) {
        	answer[i]=mailCntMap.getOrDefault(id_list[i],0);
        }
        
        return answer;
    }
}