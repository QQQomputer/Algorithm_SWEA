package d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1936 .1대1 가위바위보
public class Q1936 {
/*
A와 B가 가위바위보를 하였다.

가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.

A와 B중에 누가 이겼는지 판별해보자. 단, 비기는 경우는 없다.


[입력]

입력으로 A와 B가 무엇을 냈는지 빈 칸을 사이로 주어진다.


[출력]

A가 이기면 A, B가 이기면 B를 출력한다.
*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int rcpA = br.read();
		br.read();
		int rcpB = br.read();

		bw.write(String.valueOf(((rcpB+1)%3) == rcpA%3 ? "A":"B"));
		bw.flush();
		bw.close();
		br.close();
	}
	
	

}
