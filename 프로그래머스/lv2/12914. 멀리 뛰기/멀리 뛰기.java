import java.util.*;

class Solution {
    public static long solution(int n) {
        long answer = 0;
        
        long[] array = new long[n+1];
        
        array[1] = 1;
        if(n>=2){
            array[2] = 2;     
        }
        
        for(int i=3; i<=n;i++) {
        	array[i]=(array[i-1]+array[i-2])%1234567;
        }
        
        
        return array[n];
    }
}