package d3;

import java.util.Scanner;

public class SWEA1217_D3_거듭제곱 {
	static int N,M,result;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = 10;//sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int tc = sc.nextInt();
			
			N= sc.nextInt();
			M= sc.nextInt();
			
			result = 1;
			
			for (int i = 0; i < M; i++)
				result*=N;
			System.out.println("#"+tc+" "+result);
		}
	}	
}
