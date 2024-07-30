package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1208_Flatten {
	static boolean flag;
	static int [] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			arr = new int[101];
			
			for (int i = 0; i < N; i++)
				arr[Integer.parseInt(st.nextToken())]++;
			
			flag = true;
			int idx = 0;
			//int gap = ;
			
			while(flag) {
				
				
				
				flag=step();
				
			}
			
			
			//sb.append("#").append(t).append(" ").append(i).append("\n");

		}
		
		
		System.out.println(sb);
	}
	
	static boolean step() {
		
		return true;
	}

}
