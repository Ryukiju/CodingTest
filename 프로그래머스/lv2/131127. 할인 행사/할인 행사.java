import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //10일간의 할인목록
        Map<String, Integer> discountMap = new HashMap<>();
        
        for(int i=0; i<10; i++) {
        	discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
        }
        answer++;
    	for(int j=0; j<want.length; j++) {
    		if(discountMap.getOrDefault(want[j], 0)!=number[j]) {
    			answer--;
    			break;
    		}
    	}
//    	System.out.println(discountMap);
        
        for(int i=1; i<=discount.length-10; i++) {
        	discountMap.put(discount[i-1], discountMap.get(discount[i-1])-1);
        	discountMap.put(discount[i+9], discountMap.getOrDefault(discount[i+9], 0)+1);
        	
        	boolean allDiscount = true;
        	for(int j=0; j<want.length; j++) {
        		if(discountMap.getOrDefault(want[j], 0)!=number[j]) {
        			allDiscount = false;
        			break;
        		}
        	}
        	if(allDiscount) {
        		answer++;
        	}
//        	System.out.println(discountMap);
        }
        
        return answer;
    }
}