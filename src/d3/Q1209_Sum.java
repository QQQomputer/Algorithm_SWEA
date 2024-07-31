package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//15m
public class Q1209_Sum {
	static int [][] board;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		int N = 100;
		
		for (int t = 1; t <= T; t++) {
			
			Integer.parseInt(br.readLine());
			//
			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			
			for (int i = 0; i < N; i++) {
				int sumR=0;
				int sumC=0;
				for (int j = 0; j < N; j++) {
					//행
					sumR+=board[i][j];
					
					//열
					sumC+=board[j][i];				
				}
				max=Math.max(max, Math.max(sumR, sumC));	
			}
			
			//r-c=0
			//r+c=N-1;
			int sumD=0;
			int sumU=0;
			for (int i = 0; i < N; i++) {
				// down
				sumD+=board[i][i];
				// up
				sumU+=board[i][N-1-i];
			}
			max=Math.max(max, Math.max(sumD, sumU));
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
