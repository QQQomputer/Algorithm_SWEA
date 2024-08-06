package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//stack 버전
public class SWEA1223_D4_계산기2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,ans;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans=0;
			stack = new Stack<>();
			
			// 피연산자 0~9
			
			for (int i = 0; i < N; i++) {
				char c = (char)br.read();
				if(c == '+') {
					ans+=pop();
				}else if(c == '*')
					;
				else
					stack.push(c-'0');
			}
			br.readLine();//엔터
			
			ans+=pop();
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	static int pop() {
		int n = stack.pop();
		while(!stack.isEmpty())
			n*=stack.pop();
		
		return n;
	}
}