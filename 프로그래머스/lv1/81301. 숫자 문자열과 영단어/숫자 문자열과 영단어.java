import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuffer answerSb = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length();i++) {
        	if(Character.isDigit(s.charAt(i))) {
        		answerSb.append(s.charAt(i));
        		continue;
        	}
        	sb.append(s.charAt(i));
        	if(!map.getOrDefault(sb.toString(), "null").equals("null")) {
        		answerSb.append(map.get(sb.toString()));
        		sb.delete(0, sb.length());
        	}
        }
        
        return Integer.parseInt(answerSb.toString());
    }
}