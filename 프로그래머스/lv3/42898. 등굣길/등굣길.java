import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n+1][m+1];
		for(int y=1; y<=n;y++) {
			for(int x=1; x<=m;x++) {
				map[y][x]=1;
			}
		}

		for(int i=0; i<puddles.length;i++) {
			map[puddles[i][1]][puddles[i][0]]= -1;
		}


		for(int y=1; y<map.length;y++) {
			for(int x=1; x<map[y].length; x++) {
				if(x==1&&y==1||map[y][x]==-1) {
					continue;
				}
				//둘다 웅덩이
				if(map[y][x-1]==-1&&map[y-1][x]==-1) {
					map[y][x]= -1;
					//하나 웅덩이
				}else if(map[y][x-1]==-1||map[y-1][x]==-1) {
					map[y][x] = Math.max(map[y][x-1], map[y-1][x]);
					//웅덩이 x
				}else {
					map[y][x] = (map[y][x-1] + map[y-1][x])%1000000007;
				}
			}
		}
//		System.out.println(map[n][m]);
//
//		for(int i=0; i<=n;i++) {
//			for(int j=0; j<=m;j++) {
//				System.out.print(map[i][j]+",");
//			}
//			System.out.println();
//		}

		return map[n][m];
	}
}