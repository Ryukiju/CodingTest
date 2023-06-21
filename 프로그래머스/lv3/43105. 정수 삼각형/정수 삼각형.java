class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int sumArr[][] = new int[triangle.length][triangle.length];
//        for(int i=0; i<triangle.length;i++) {
//        	for(int j=0; j<triangle[i].length;j++) {
//        		System.out.print(triangle[i][j]+", ");
//        	}
//        	System.out.println();
//        }
        
        sumArr[0][0] = triangle[0][0];
        for(int y=1; y<triangle.length; y++) {
        	
        	for(int x=0; x<triangle[y].length;x++) {
        		//왼쪽끝일경우
        		if(x==0) {
        			sumArr[y][x] = triangle[y][x]+sumArr[y-1][x];
            	//오른쪽끝일경우
        		}else if(x==triangle[y].length-1) {
        			sumArr[y][x] = triangle[y][x]+sumArr[y-1][x-1];
        		//가운데일경우
        		}else {
        			sumArr[y][x] = triangle[y][x]+Math.max(sumArr[y-1][x-1],sumArr[y-1][x]);
        		}
        	}
        	
        }

//        System.out.println("====================");
//        
//        for(int i=0; i<sumArr.length;i++) {
//        	for(int j=0; j<sumArr[i].length;j++) {
//        		System.out.print(sumArr[i][j]+", ");
//        	}
//        	System.out.println();
//        }
        
        for(int i=0; i<sumArr.length;i++) {
        	answer= Math.max(sumArr[sumArr.length-1][i], answer);
        }
        
        return answer;
    }
}