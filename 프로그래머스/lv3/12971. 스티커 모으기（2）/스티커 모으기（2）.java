import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length<=3) {
        	int answer=0;
        	for(int i=0; i<sticker.length; i++) {
        		answer=Math.max(answer, sticker[i]);
        	}
        	return answer;
        }
        
        //첫번째꺼 땔경우
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(sticker[0]);
        list1.add(sticker[0]);
        for(int i=2;i<sticker.length-1;i++) {
        	list1.add(Math.max(list1.get(i-1), list1.get(i-2)+sticker[i]));
        }
        // System.out.println("list1 :"+list1);

        //두번째꺼 땔경우
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(sticker[1]);
        for(int i=2;i<sticker.length;i++) {
        	list2.add(Math.max(list2.get(i-1), list2.get(i-2)+sticker[i]));
        }
        // System.out.println("list2 :"+list2);
        
        return Math.max(list1.get(list1.size()-1), list2.get(list2.size()-1));
    }
}