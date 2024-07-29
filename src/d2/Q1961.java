package d2;

import java.io.*;
import java.util.*;

//1961 .숫자 배열 회전
public class Q1961 {
/*
N x N 행렬이 주어질 때,

시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.


[제약 사항]

N은 3 이상 7 이하이다.

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에 N이 주어지고,

다음 N 줄에는 N x N 행렬이 주어진다.

[출력]

출력의 첫 줄은 '#t'로 시작하고,

다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.

입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


*/
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {

		int T = readInt();
		
//		1	2	3
//		4	5	6
//		7	8	9
		
		StringBuilder  sb;
		
		for(int t = 0; t<T;t++) {
			int n = readInt();
			int arr[][] = new int[n][n];
			
			makeArr(arr, n);
			
			sb = new StringBuilder();
			sb.append("#").append(t+1).append("\n");
			for(int i=0;i<n;i++) {
				for(int q=0;q<3;q++) {

					for(int j=0;j<n;j++) {
						//System.out.println(j +" "+ ((n-1)-i) + q);
						if(q==0)
							sb.append(arr[(n-1)-j][i]);
						else if(q==1)
							sb.append(arr[(n-1)-i][(n-1)-j]);
						else if(q==2)
							sb.append(arr[j][(n-1)-i]);
					}
				
					sb.append(" ");
				}
				sb.setLength(sb.length()-1);
				
				sb.append("\n");
			}
			bw.write(String.valueOf(sb.toString()));
		}
		
		
		
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void makeArr(int [][] arr, int n) throws IOException {	
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				arr[i][j] = readInt();
		
	}
	
    public static int readInt() throws IOException {
        int result = 0;
        boolean negative = false;
        int read = br.read();
        
        while (read < '0' || read > '9') {
            if (read == '-') {
                negative = true;
            }
            read = br.read();
        }

        while (read >= '0' && read <= '9') {
            result = result * 10 + (read - '0');
            read = br.read();
        }
        return negative ? -result : result;
    }
}
