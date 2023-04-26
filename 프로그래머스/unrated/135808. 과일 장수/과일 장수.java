import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> scoreList = new ArrayList<>();
        for(Integer num:score) {
        	scoreList.add(num);
        }
        scoreList.sort(null);
        for(int i=1; i<=scoreList.size()/m;i++) {
        	answer+=scoreList.get(scoreList.size()-m*i)*m;
        }
        return answer;
    }
}