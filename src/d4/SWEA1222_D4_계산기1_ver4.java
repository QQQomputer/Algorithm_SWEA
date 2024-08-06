package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1222_D4_계산기1_ver4 {
    
    static int N, ans;
    static Stack<Integer> stack;
    static Stack<Character> ops;
    static int[][] opsPriority = {{'+','-'},{'*','/','%'},{'(',')'}};
    
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
            
            ans = calcPostFix();
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static int calcPostFix() {
        Stack<Integer> calcStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            int token = stack.pop();
            if (token >= 0 && token <= 9) {
                calcStack.push(token);
            } else {
                int b = calcStack.pop();
                int a = calcStack.pop();
                switch ((char) token) {
                    case '+': calcStack.push(a + b); break;
                    case '-': calcStack.push(a - b); break;
                    case '*': calcStack.push(a * b); break;
                    case '/': calcStack.push(a / b); break;
                    case '%': calcStack.push(a % b); break;
                }
            }
        }
        return calcStack.pop();
    }
    
    static boolean checkOps(int c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    
    static int order(int c) {
        for (int i = 0; i < opsPriority.length; i++)
            for (int j = 0; j < opsPriority[i].length; j++)
                if (c == opsPriority[i][j])
                    return i;
        return -1;
    }
}