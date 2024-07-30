package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1204_최빈수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int [] arr;
		for (int t = 1; t <= T; t++) {
			
			Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			arr = new int[101];
			
			for (int i = 0; i < 1000; i++)
				arr[Integer.parseInt(st.nextToken())]++;
			
			int [] tmp = new int[101];
			
			System.arraycopy(arr, 0, tmp, 0, arr.length);

			Arrays.sort(tmp);
			
			for (int i = 100; i >= 0; i--) {
				if(arr[i]==tmp[100]) {
					sb.append("#").append(t).append(" ").append(i).append("\n");
					break;
				}
			}
			
		}
		System.out.println(sb);
	}

}
