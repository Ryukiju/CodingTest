import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
//        Map<String, Set<String>> map = new HashMap<>();
        
        //1. 길이비교
        //2. charAt Index증가시키면서 비교
        List<List<String>> banLists = new ArrayList<>();
        
        for(int i=0; i<banned_id.length; i++) {
            List<String> banList = new ArrayList<>();
        	for(int j=0; j<user_id.length; j++) {
    			boolean possible = true;
        		//길이가 같고
        		if(banned_id[i].length()==user_id[j].length()) {
        			//charAt 하나씩 비교
        			for(int x=0; x<banned_id[i].length();x++) {
        				if(banned_id[i].charAt(x)=='*') {
        					continue;
        				}else {
        					if(banned_id[i].charAt(x)==user_id[j].charAt(x)) {
        						continue;
        					}else {
        						//charAt이 다르면 종료
        						possible = false;
        						break;
        					}
        				}
        			}
        		}else {
					possible = false;
        		}
        		//banned_id랑 user_id랑 일치하면
        		if(possible) {
        			banList.add(user_id[j]);
        		}
        	}
        	banLists.add(banList);
        }
        
//        System.out.println(banLists);


        Queue<List<String>> queue = new LinkedList<>();
        
        for(int i=0; i<banLists.get(0).size();i++) {
        	List<String> list = new ArrayList<>();
        	list.add(banLists.get(0).get(i));
        	queue.add(list);
        }
//        System.out.println(queue);
        
        for(int i=1; i<banLists.size();i++) {
        	int queueSize = queue.size();
        	for(int x=0; x<queueSize;x++) {
            	List<String> q = queue.poll();
            	for(int j=0; j<banLists.get(i).size();j++) {
                	List<String> list = new ArrayList<>(q);
                	if(!list.contains(banLists.get(i).get(j))) {
                    	list.add(banLists.get(i).get(j));
                    	queue.add(list);	
                	}
            	}	
        	}
        }
//        System.out.println(queue);
        
        Set<Set<String>> resultSet = new HashSet<Set<String>>();
        
        while(!queue.isEmpty()) {
        	List<String> list = queue.poll();
        	list.sort(null);
//        	System.out.println(list);
        	Set<String> set = new HashSet<>();
        	for(int i=0; i<list.size(); i++) {
        		set.add(list.get(i));
        	}
        	if(set.size()==banned_id.length) {
        		resultSet.add(set);
        	}
        }
//        System.out.println(resultSet);
        return resultSet.size();
    }
}