package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1222_D4_계산기1 {
	static int N,ans;
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			ans = 0;
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				char c = (char)br.read();
				if(c == '+') {
					
				}else
					stack.push((char)(c-48));
			}
			br.readLine();
			
			for (char c : stack)
				ans+=c;
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
