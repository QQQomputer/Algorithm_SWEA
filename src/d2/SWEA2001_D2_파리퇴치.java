package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//누적합 버전
public class SWEA2001_D2_파리퇴치 {
	static int N,M,max;
	static int [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = 0;
			board = new int[N+1][N+1];
			
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++)
					board[i][j]=Integer.parseInt(st.nextToken())+board[i][j-1]+board[i-1][j]-board[i-1][j-1];
			}
			
			for (int r = M; r < N+1; r++) {
				for (int c = M; c < N+1; c++) {
					max = Math.max(max, kill(r,c));
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	static int kill(int r, int c) {
		return board[r][c] - board[r-M][c] - board[r][c-M] + board[r-M][c-M];
	}

}
