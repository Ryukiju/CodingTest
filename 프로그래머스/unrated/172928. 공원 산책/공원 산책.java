class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int curX=0,curY=0;
        
        for(int i=0; i<park.length;i++) {
        	if(park[i].indexOf("S")>=0) {
        		curX = i;
        		curY = park[i].indexOf("S");
        	}
        }
        
        for(int i=0; i<routes.length;i++) {
        	String dir = routes[i].split(" ")[0];
        	int count = Integer.parseInt(routes[i].split(" ")[1]);
        	
        	int moveX = 0;
        	int moveY = 0;
        	
        	boolean reset = false;
        	
        	for(int j=1; j<=count; j++) {
        		
        		if(dir.equals("N")) {
        			if(curX-j<0) {
        				reset = true;
        			}else if(park[curX-j].charAt(curY)=='X'){
        				reset = true;
        			}else {
        				moveX = -count;
        			}
        		}
        		if(dir.equals("S")) {
        			if(curX+j>=park.length) {
        				reset = true;
        			}else if(park[curX+j].charAt(curY)=='X'){
        				reset = true;
        			}else {
        				moveX = count;
        			}
        		}
        		if(dir.equals("W")) {
        			if(curY-j<0) {
        				reset = true;
        			}else if(park[curX].charAt(curY-j)=='X'){
        				reset = true;
        			}else {
        				moveY = -count;
        			}
        		}
        		if(dir.equals("E")) {
        			if(curY+j>=park[0].length()) {
        				reset = true;
        			}else if(park[curX].charAt(curY+j)=='X'){
        				reset = true;
        			}else {
        				moveY = count;
        			}
        		}
        	}
        	if(!reset) {
        		curX+=moveX;
        		curY+=moveY;
        	}
        }

        answer[0] = curX;
        answer[1] = curY;
        return answer;
    }
}