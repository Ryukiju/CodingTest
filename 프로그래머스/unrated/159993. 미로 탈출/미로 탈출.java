import java.util.*;

public class pos {
	int x;
	int y;
	int level;
	pos(int x, int y, int level){
		this.x=x;
		this.y=y;
		this.level=level;
	}
}

class Solution {
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};
	
	public static int bfs(String[] maps, int startX, int startY, int width, int height, int endX, int endY) {

        
        boolean[][] visitedPos = new boolean[width][height]; 
        for(int i=0; i<width;i++) {
        	for(int j=0; j<height;j++) {
        		visitedPos[i][j] = false;
        	}
        }
        
		Queue<pos> q = new LinkedList<>();

		q.add(new pos(startX, startY, 0));
		visitedPos[startX][startY] = true;

		while(!q.isEmpty()) {
			pos now = q.poll();

			if(now.x==endX&&now.y==endY) {
				return now.level;
			}

			for(int i=0; i<4;i++) {
				int stepX = now.x + dX[i];
				int stepY = now.y + dY[i];
				int stepLevel = now.level+1;

				if(stepX<0 || stepY < 0 || stepX>=width || stepY>=height) {
					continue;
				}else {
					if(maps[stepX].charAt(stepY)=='X'||visitedPos[stepX][stepY]) {
						continue;
					}
					q.add(new pos(stepX, stepY, stepLevel));
					visitedPos[stepX][stepY] = true;
				}

			}

		}
		
		return -1;
	}
	
	
	public static int solution(String[] maps) throws InterruptedException {
        int answer = 0;
        pos startPosition = null;
        pos leverPosition = null;
        pos exitPosition = null;
        
        
        
        for(int index=0; index<maps.length;index++) {  
        	for(int y=0;y<maps[0].length();y++) {
        		char c = maps[index].charAt(y);
        		
        		if(c=='S') {
        			startPosition = new pos(index, y, 0);
        		}
        		if(c=='L') {
        			leverPosition = new pos(index, y, 0);
        		}
        		if(c=='E') {
        			exitPosition = new pos(index, y, 0);
        		}
        	}
        }
        
        answer += bfs(maps, startPosition.x,startPosition.y,maps.length,maps[0].length(),leverPosition.x,leverPosition.y);
        
        if(answer==-1) {
        	return -1;
        }else {
        	int answer2 = bfs(maps, leverPosition.x,leverPosition.y,maps.length,maps[0].length(),exitPosition.x,exitPosition.y);
        	if(answer2==-1) {
        		return -1;
        	}
        	answer+= answer2;
        }
        
        
        return answer;
    }
}