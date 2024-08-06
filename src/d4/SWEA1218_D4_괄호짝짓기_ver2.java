package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
//stack 버전
//28m
public class SWEA1218_D4_괄호짝짓기_ver2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,ans;
	static Stack<Character> stack;
	
	// [(, ), <, >, [, ], {, }]
	// 40, 41, 60, 62, 91, 93, 123, 125
	public static void main(String[] args) throws IOException {
		int T = 10;
	
		for (int t = 1; t <= T; t++) {
			ans=1;
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				if(isOpen(c))
					stack.push(c);				
				else if(Math.abs(c-stack.pop())>2) {
					ans=0;
					break;
				}
			}
		
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean isOpen(char c) {
		return c == '(' || c == '<' || c == '[' || c == '{';
	}
}