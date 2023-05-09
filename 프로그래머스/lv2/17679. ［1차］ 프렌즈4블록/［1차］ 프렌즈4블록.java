import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        //2차배열 변환후 개발 --> null값 포함을 위함
        Character[][] boardArray = new Character[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		boardArray[i][j] = board[i].charAt(j);
        	}
        }
        
        
        while(true) {
        	List<int[]> posList = find4BlockPos(boardArray);
        	
//			System.out.println("=====================");
//	        for(int i=0; i<m; i++) {
//	        	for(int j=0; j<n; j++) {
//	        		System.out.print(boardArray[i][j]+",");
//	        	}
//	        	System.out.println();
//	        }
//			System.out.println("=====================");
            
        	//사각형이 없을때 빠져나옴
        	if(posList.size()==0) {
        		break;
        	}
        	
        	for(int[] pos: posList) {
        		if(boardArray[pos[0]][pos[1]]!=null) {
        			answer++;
        		}
        		if(boardArray[pos[0]][pos[1]+1]!=null) {
        			answer++;
        		}
        		if(boardArray[pos[0]+1][pos[1]]!=null) {
        			answer++;
        		}
        		if(boardArray[pos[0]+1][pos[1]+1]!=null) {
        			answer++;
        		}
        		
        		boardArray[pos[0]][pos[1]] = null;
        		boardArray[pos[0]][pos[1]+1] = null;
        		boardArray[pos[0]+1][pos[1]] = null;
        		boardArray[pos[0]+1][pos[1]+1] = null;
        	}
        	
//			System.out.println("=====================");
//	        for(int i=0; i<m; i++) {
//	        	for(int j=0; j<n; j++) {
//	        		System.out.print(boardArray[i][j]+",");
//	        	}
//	        	System.out.println();
//	        }
//			System.out.println("=====================");
        	
			for(int i=0; i<m-1; i++) {
				for(int y=m-1; y>0; y--) {
					for(int x=0; x<n; x++) {
						if(boardArray[y][x]==null) {
							boardArray[y][x]=boardArray[y-1][x];
							boardArray[y-1][x]=null;
						}

					}
				}
			}
        }
        
        System.out.println("answer :"+answer);
        return answer;
    }
    
    public static List<int[]> find4BlockPos(Character[][] boardArray) {
    	
    	List<int[]> result = new ArrayList<>();

        for(int x=0; x<boardArray.length-1; x++) {
        	for(int y=0; y<boardArray[x].length-1; y++) {
        		//널이 아니고
        		if(boardArray[x][y]!=null||boardArray[x+1][y]!=null||boardArray[x][y+1]!=null||boardArray[x+1][y+1]!=null) {
        			//사각형값이 모두 같으면 맨왼쪽 위의 x,y좌표 리턴
        			if(boardArray[x][y]==boardArray[x+1][y]&&boardArray[x][y]==boardArray[x][y+1]&&boardArray[x][y]==boardArray[x+1][y+1]) {
        				int[] ele = new int[2];
        				ele[0] = x;
        				ele[1] = y;
        				result.add(ele);
        			}
        		}
        	}
        }
    	return result;
    }
}