package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//45m
public class Q1210_Ladder1 {
	static int [][] board;
	static int N,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		int dest=0;
		for (int t = 1; t <= T; t++) {
			Integer.parseInt(br.readLine());
			board = new int[100][100];//arrays.fill
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for (int i = 0; i < 100; i++)
				if(board[99][i]==2) {
					dest=i;
					break;
				}

			ans = dfs(99,dest);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int depth,int x) {
		if(depth == 0) {
			return x;
		}
		
		//왼쪽
		if(check(x-1)&&board[depth][x-1]==1){//1이 있으면
			int cur = x-1;
			while(cur-->=0) {
				if(board[depth-1][cur]==1)
					return dfs(depth-1,cur);
			}
		}
			;
		//오른쪽
		if(check(x+1)&&board[depth][x+1]==1){//1이 있으면
			int cur = x+1;
			while(cur++<100) {
				if(board[depth-1][cur]==1)
					return dfs(depth-1,cur);
			}
		}
		
		//없으면 위로
		return dfs(depth-1,x);
	}
	
	static boolean check(int col) {
		return col>=0 && col<100;
	}
}
