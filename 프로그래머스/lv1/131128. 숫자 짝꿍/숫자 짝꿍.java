class Solution {
    public static String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer();
        
        int[] xArray = {0,0,0,0,0,0,0,0,0,0};
        int[] yArray = {0,0,0,0,0,0,0,0,0,0};
        
        for(int i=0; i<X.length(); i++) {
        	Integer value = Integer.parseInt(X.substring(i,i+1));
        	xArray[value]++;
        }

        for(int i=0; i<Y.length(); i++) {
        	Integer value = Integer.parseInt(Y.substring(i,i+1));
        	yArray[value]++;
        }
        
        for(int i=9; i>=0; i--) {
        	if(xArray[i]>0&&yArray[i]>0) {
        		for(int j=0; j<Math.min(xArray[i], yArray[i]);j++) {
        			answer.append(i);
        		}
        	}
        }
        
        if(answer.length()>0) {
            
            if(answer.charAt(0)=='0') {
            	answer.replace(0, answer.length(), "0");
            }
        }else {
        	return "-1";
        }

        
        return answer.toString();
    }
}