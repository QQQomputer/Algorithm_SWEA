package d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2058.자릿수 더하기
public class Q2058 {
	
/*
하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.


[제약 사항]

자연수 N은 1부터 9999까지의 자연수이다. (1 ≤ N ≤ 9999)


[입력]

입력으로 자연수 N이 주어진다.


[출력]

각 자릿수의 합을 출력한다.
*/
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(sum(N)));
        bw.flush();
        bw.close(); 
        br.close();
	}
	
	//자릿수 합치기
	static int sum(int n) {
		int sumVal = 0;
		
		while(n>=10) {
			sumVal += n%10;
			n /= 10;
		}
		sumVal += n%10;
		return sumVal;
	}

}
