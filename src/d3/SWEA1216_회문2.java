package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1216_회문2 {
	static int T,N,tc,max,len;
	static String [] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = 10;
		N = 100;
		
		for (int t = 1; t <= T; t++) {
			tc = Integer.parseInt(br.readLine());
			board = new String [N];
			max=0;
			for (int i = 0; i < N; i++)
				board[i] = br.readLine();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int maxLen = N-j;
					for (int len = maxLen; len > 0; len--) {
						palindrome(i,j,len,false);
						palindrome(j,i,len,true);
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void palindrome(int r, int c, int len, boolean isVertical) {
		if(len<=max)
			return;
		
		if(!isVertical) {
			int f = c;
			int l = c+len-1;
			while(f<l) {
				if(board[r].charAt(f)!=board[r].charAt(l))
					return;	
				f++;
				l--;
			}
		}
		
		if(isVertical) {
			int f = r;
			int l = r+len-1;
			while(f<l) {
				if(board[f].charAt(c)!=board[l].charAt(c))
					return;
				f++;
				l--;
			}
		}
		
		max = len;
	}
}
