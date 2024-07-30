package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2001_파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = N-M+1;
		int [] board = new int[S*S];
		int [] arr = new int[N+M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < S; j++) {
				int idx = i*N+M;
				arr[idx%N] = Integer.parseInt(st.nextToken());
				if(i*N+j>=S) {
					for (int k = M-1; k >= 0; k++) {
						
					}
				}
					
			}
			
			
//			arr[i%N]=
//			if()
//			
//			int 
			
		}
		
	}
	
	

}
