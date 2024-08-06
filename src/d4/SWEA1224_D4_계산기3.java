package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//후위 표기식 변환 버전
public class SWEA1224_D4_계산기3 {
	
	static int N,ans;
	static Stack<Integer> stack;
	static Stack<Character> ops;
	static int [][] opsPriority = {{'+','-'},{'*','/','%'},{'(',')'}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			ans = 0;
			stack = new Stack<>();
			ops = new Stack<>();
			
			for (int i = 0; i < N; i++) {				
				int c = br.read();

				// 연산자 우선 순위
				int curOrd = order(c);

				//연산자일 경우
				if(curOrd>-1) {

					// 괄호 ( 일 경우
					if(c == '(') {
						ops.push((char)c);
					}
					// 괄호 ) 일 경우
					else if(c == ')') {
						c = ops.pop();
						while(c != '(') {
							stack.push(c);
							c = ops.pop();
						}
					}
					// 그 외 연산자
					else {						
						// "현재 연산자 vs ops 스택 맨위" 연산자 우선순위 비교
						// 현재 연산자 > stack연산자	=> 멈춤
						// 괄호일 경우 				=> 멈춤
						while(!ops.isEmpty() && curOrd <= order(ops.peek()) && ops.peek() != '(') {
							// 현재 연산자 ≤ stack연산자	=> 후위 표기로 빼냄, 계속 진행
							stack.push((int)ops.pop());
						}
						// 현재 연산자 스택 추가
						ops.push((char)c);
					}
				}
				
				//피연산자일 경우
				else
					stack.push(c-'0');
			}
			br.readLine();// 엔터 - 줄바꿈
			
			//마지막 연산자 빼냄
			while(!ops.isEmpty()) {
				stack.push((int)ops.pop());
			}
			
//			for (int i : stack) {
//				System.out.print((char)(i>9?i:i+'0')+" ");
//			}
//			System.out.println();
			
			ans = calcPostFix(stack.pop());
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int calcPostFix(int ops) {
		
		int c1 = stack.pop();		
		if(checkOps(c1)) c1 = calcPostFix(c1);
		
		int c2 = stack.pop();		
		if(checkOps(c2)) c2 = calcPostFix(c2);
		
				if(ops == '+')	return c2 + c1;
		else 	if(ops == '-')	return c2 - c1;
		else 	if(ops == '*')	return c2 * c1;
		else 	if(ops == '/')	return c2 / c1;
		else 	if(ops == '%')	return c2 % c1;
		
								return -1;
	}
	
	static boolean checkOps(int c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
	}
	
	//연산자 우선 순위
	// -1 	: 피연산자
	// else	: 연산자
	//			0 - {+, -}
	//			1 - {*, /, %}
	//			2 - {(, )}
	static int order(int c) {
		for (int i = 0; i < opsPriority.length; i++)
			for (int j = 0; j < opsPriority[i].length; j++)
				if(c == opsPriority[i][j])
					return i;
		return -1;
	}
}
