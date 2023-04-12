import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    	String[] answer = new String[players.length];
        Map<Integer, String> rankMap = new HashMap<>();
        Map<String, Integer> playerMap = new HashMap<>();
        
        for(int i=0; i<players.length;i++) {
        	rankMap.put(i, players[i]);
        	playerMap.put(players[i], i);
        }
        
        for(String calling: callings) {
        	int nowRank = playerMap.get(calling);
        	String frontPlayer = rankMap.get(nowRank-1);
        	
        	//playerMap 변환
        	playerMap.put(calling, nowRank-1);
        	playerMap.put(frontPlayer, nowRank);
        	
        	//map2 변환
        	rankMap.put(nowRank-1, calling);
        	rankMap.put(nowRank, frontPlayer);
        }
        for(int i=0; i<players.length;i++) {
        	answer[i]=rankMap.get(i);
        }
        return answer;
    }
}