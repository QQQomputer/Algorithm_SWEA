package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1222_D4_계산기1_ver3 {
    
    static int N, ans;
    static Stack<Integer> stack;
    static Stack<Character> ops;
    static final String OPERATORS = "+-*/%()";
	static int [][] opsPriority = {{'+','-'},{'*','/','%'},{'(',')'}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            ans = 0;
            stack = new Stack<>();
            ops = new Stack<>();
            
            String expression = br.readLine();
            for (char c : expression.toCharArray()) {
                int curOrd = order(c);
                
                if (curOrd > -1) {
                    if (c == '(') {
                        ops.push(c);
                    } else if (c == ')') {
                        while (!ops.isEmpty() && ops.peek() != '(') {
                            stack.push((int) ops.pop());
                        }
                        if (!ops.isEmpty()) ops.pop(); // Remove '('
                    } else {
                        while (!ops.isEmpty() && order(ops.peek()) >= curOrd && ops.peek() != '(') {
                            stack.push((int) ops.pop());
                        }
                        ops.push(c);
                    }
                } else if (Character.isDigit(c)) {
                    stack.push(c - '0');
                }
            }
            
            while (!ops.isEmpty()) {
                stack.push((int) ops.pop());
            }
            //3 4 + 5 * + 6 + 7
            for (int i : stack) {
				System.out.print((char)(i>9?i:i+48)+", ");
			}
            System.out.println();
            ans = calcPostFix(stack.pop());
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static int calcPostFix(int ops) {
//        int c1 = stack.pop();
//        if (checkOps(c1)) c1 = calcPostFix(c1);
//               
//        int c2 = stack.pop();
//        if (checkOps(c2)) c2 = calcPostFix(c2);
    	
        int c1 = stack.pop();
        int c2 = stack.pop();
        if (checkOps(c1)) c1 = calcPostFix(c1);
        if (checkOps(c2)) c2 = calcPostFix(c2);
        
        switch ((char) ops) {
            case '+': return c2 + c1;
            case '-': return c2 - c1;
            case '*': return c2 * c1;
            case '/': return c2 / c1;
            case '%': return c2 % c1;
            default: return -1;
        }
    }
    
    static boolean checkOps(int c) {
        return OPERATORS.indexOf((char) c) != -1;
    }
    
//    static int order(int c) {
//        return OPERATORS.indexOf((char) c) / 2;
//    }
	static int order(int c) {
		for (int i = 0; i < opsPriority.length; i++)
			for (int j = 0; j < opsPriority[i].length; j++)
				if(c == opsPriority[i][j])
					return i;
		return -1;
	}
}