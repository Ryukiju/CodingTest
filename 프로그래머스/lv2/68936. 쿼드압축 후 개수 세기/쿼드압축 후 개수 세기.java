import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        Queue<Square> queue = new LinkedList<Square>();
        
        queue.add(new Square(0, 0, arr.length));
        while(!queue.isEmpty()) {
        	Square square = queue.poll();

        	//정사각형 한변의길이가 1일때
        	if(square.length%2>0) {
        		if(arr[square.x][square.y]==0) answer[0]+=1;
        		if(arr[square.x][square.y]==1) answer[1]+=1;
        	//정사각형 변의 길이가 2이상일때
        	}else {
        		
        		
        		boolean compressing = true;
        		int value = arr[square.x][square.y];
        		
        		//압축 판단
        		for(int i=0; i<square.length;i++) {
        			for(int j=0; j<square.length;j++) {
        				if(value!=arr[square.x+i][square.y+j]) {
        					compressing=false;
        					break;
        				}
        			}
        			if(!compressing) {
        				break;
        			}
        		}
        		
        		//압축이면 플러스
        		if(compressing) {
        			if(arr[square.x][square.y]==0) answer[0]+=1;
        			if(arr[square.x][square.y]==1) answer[1]+=1;
        		//압축이 아니면 q에 push
        		}else {
        			queue.add(new Square(square.x,square.y,square.length/2));
        			queue.add(new Square(square.x+square.length/2,square.y,square.length/2));
        			queue.add(new Square(square.x,square.y+square.length/2,square.length/2));
        			queue.add(new Square(square.x+square.length/2,square.y+square.length/2,square.length/2));
        		}
        	}
        }
        
        System.out.println("["+answer[0]+","+answer[1]+"]");
        return answer;
    }
}

class Square {
	int x;
	int y;
	int length;
	
	public Square(int x, int y, int length) {
		this.x=x;
		this.y=y;
		this.length=length;
	}
}