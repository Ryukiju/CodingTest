import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux,luy,rdx,rdy;
        List<Integer> minXList = new ArrayList<>();
        List<Integer> maxXList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        
        int index = 0;
        for(String row : wallpaper){
        	
        	if(row.indexOf("#") >= 0) {
        		minXList.add(row.indexOf("#"));
        		maxXList.add(row.lastIndexOf("#"));
        	}
        	
        	if(row.contains("#")) {
        		yList.add(index);
        	}
        	
        	
        	index++;
        }

        lux= Collections.min(yList);
        luy= Collections.min(minXList);
        rdx= Collections.max(yList);
        rdy= Collections.max(maxXList);
        
        int[] answer = {lux,luy,rdx+1,rdy+1};
        
        return answer;
    }
}