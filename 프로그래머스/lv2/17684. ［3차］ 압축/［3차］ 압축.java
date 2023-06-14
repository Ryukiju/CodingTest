import java.util.*;

class Solution {
    public int[] solution(String msg) {
    	List<Integer> answerList = new ArrayList<>();
    	Map<String, Integer> map = new HashMap<>();
    	
    	char alpabet = 'A';
    	Integer number;
    	for(number=1; number<=26;number++) {
    		map.put(String.valueOf((char)(alpabet+number-1)), number);
    	}
//    	System.out.println(map);
//    	System.out.println(number);
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i=0; i<msg.length();i++) {
    		String w = sb.toString()+msg.charAt(i);
    		String c=null;
    		if(i+1<msg.length()) {
    			c= String.valueOf(msg.charAt(i+1));
    		}
//    		System.out.println("w :"+w+", c :"+c);
    		
    		if(map.getOrDefault(w+c,-1)>0) {
    			sb.append(msg.charAt(i));
    		}else {
    			answerList.add(map.get(w));
    			map.put(w+c, number);
    			number++;
    			sb.delete(0, sb.length());
//    	    	System.out.println(map);
    		}
    		
    	}
        
//        System.out.println(answerList);
    	//answerList => answer array 변환
        int[] answer = new int[answerList.size()];
    	for(int i=0; i<answerList.size();i++) {
    		answer[i]=answerList.get(i);
    	}
        return answer;
    }
}