package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2005_파스칼의삼각형 {
	//f(1)	>	1
	//f(2)	>	1	1
	//f(3)	>	1	2	1
	//f(4)	>	1	3	3	1
	//f(5)	>	1	4	6	4	1
	//f(6)	>	1	5	10	10	5	1
	//f(7)	>	1	6	15	20	15	6	1
	//f(8)	>	1	7	21	35	35	21	7	1
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int [][] board = new int[10][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//파스칼 삼각형 만들기
		board[0] = new int[]{1};
		N = 10;
		make(1);
		
		//System.out.println(Arrays.deepToString(board));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				String str =Arrays.toString(board[i]).replace(",", "");
				System.out.println(str.substring(1, str.length()-1));
				sb.append(str.substring(1, str.length()-1)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void make(int depth) {
		if(depth==N)
			return;
		
		int [] arr = new int[depth+2];
		
		System.arraycopy(board[depth-1], 0, arr, 1, depth);
		
		for (int i = 0; i < arr.length-2; i++) {
			arr[i]=arr[i]+arr[i+1];
		}
		
		//System.out.println(Arrays.toString(arr));
		
		board[depth] = Arrays.copyOf(arr,arr.length-1);
		make(depth+1);
	}

}
