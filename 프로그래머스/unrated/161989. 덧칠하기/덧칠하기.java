class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int first=0;
        int end = 0;
        for(int i=0; i<section.length;i++){
             if(first==0){
                 first = section[i];
                 answer++;
             }else{
                 if(section[i]-first >= m){
                     first = 0;
                     i--;
                 }
             }
        }
        
        return answer;
    }
}