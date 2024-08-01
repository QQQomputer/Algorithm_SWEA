package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1215_회문1 {
	static int T,N,sum,len;
	static char [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = 10;
		N = 8;
		
		for (int t = 1; t <= T; t++) {
			len = Integer.parseInt(br.readLine());
			board = new char[N][N];
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j]= str.charAt(j);
				}
			}
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N-(len-1); j++) {
					if(palindrome(i,j,false))
						sum++;
					if(palindrome(j,i,true))
						sum++;
				}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean palindrome(int row, int col, boolean isVertical) {
		boolean flag = true;
		
		//수평일 때
		if(!isVertical) {
			int l = col;
			int r =	col+len-1;
			while(l<r){
				if(board[row][l]!=board[row][r]) {
					flag=false;
					break;
				}
				l++;
				r--;
			}
			
		}
		//수직일 때
		else {// if(isVertical) {
			int l = row;
			int r =	row+len-1;
			while(l<r){
				if(board[l][col]!=board[r][col]) {
					flag=false;
					break;
				}
				l++;
				r--;
			}
		}
		
		return flag;
	}
}
