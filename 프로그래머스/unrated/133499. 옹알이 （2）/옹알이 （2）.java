class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++) {
        	String beforeWord = null;
        	boolean speak = false;
        	StringBuffer sb = new StringBuffer();
        	for(int index=0; index<babbling[i].length();index++) {
        		sb.append(babbling[i].charAt(index));
        		speak = false;
        		if(sb.length()==2) {
        			if(sb.toString().equals("ye")&&!sb.toString().equals(beforeWord)) {
        				beforeWord = "ye";
        				sb.delete(0, 2);
        				speak= true;
        			}else if(sb.toString().equals("ma")&&!sb.toString().equals(beforeWord)) {
        				beforeWord = "ma";
        				sb.delete(0, 2);
        				speak= true;
        			}else {
        				speak = false;
        			}
        			
        		}else if(sb.length()==3) {
        			if(sb.toString().equals("aya")&&!sb.toString().equals(beforeWord)) {
        				beforeWord = "aya";
        				sb.delete(0, 3);
        				speak = true;
        			}else if(sb.toString().equals("woo")&&!sb.toString().equals(beforeWord)) {
        				beforeWord = "woo";
        				sb.delete(0, 3);
        				speak = true;
        			}else {
        				speak = false;
        				break;
        			}
        		}
        	}
        	if(speak) {
//        		System.out.println("test :"+babbling[i]);
        		answer++;
        	}
        	
        }
        return answer;
    }
}