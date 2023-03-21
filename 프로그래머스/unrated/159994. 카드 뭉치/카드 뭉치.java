import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        String resultString="";

    	int i=0,j=0;
        for(String word: goal) {
        	boolean find = false;
        	
        	if(i<cards1.length && cards1[i].equals(word)) {
        		i++;
        		find = true;
        	}
        	
        	
        	if(find==false) {
        		if(j<cards2.length && cards2[j].equals(word)) {
            		j++;
            		find = true;
            	}
        	}
        	
        	if(find) {
        		resultString+="yes";
        	}else {
        		resultString+="no";
        	}
        }
        System.out.println(resultString);
        
        if(resultString.contains("no")) {
        	answer ="No";
        }else {
        	answer ="Yes";
        }
        	
        return answer;
    }
}