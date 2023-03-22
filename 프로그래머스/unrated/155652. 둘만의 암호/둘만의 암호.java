class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i=0; i<s.length();i++){
            char before = s.charAt(i);
        	for(int j=0;j<index;j++) {
            	before++;
                for(int x=0; x<skip.length();x++) {
                	if(before=='{') {
                		before = 'a';
                	}
                	if(before==skip.charAt(x)) {
                		j--;
                	}
                }
        	}
        	answer+=before;
        }
        return answer;
    }
}