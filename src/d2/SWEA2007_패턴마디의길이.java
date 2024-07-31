package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007_패턴마디의길이 {
	//마디 최대 길이 10
	//출력 값은 최소 3
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		char [] arr;
		
		for (int t = 1; t <= T; t++) {			
			String str = br.readLine();
			arr = str.toCharArray();
			sb.setLength(0);
			
			for (int i = 1; i <= 10; i++) {
				sb.append(arr[i-1]);
				
				for (int j = 1; j < 30/i; j++) {
//					System.out.println(str.substring(j*i,j*i+i));
//					System.out.println(sb);
//					System.out.println(sb.equals(str.substring(j*i,j*i+i)));
//					System.out.println(sb.toString().equals(str.substring(j*i,j*i+i)));
//					System.out.println(sb.toString().compareTo(str.substring(j*i,j*i+i)));
					if(!sb.toString().equals(str.substring(j*i,j*i+i)))
						break;
					
					if(j+1>=30/i) {
						ans.append("#").append(t).append(" ").append(i).append("\n");
						i=10;
					}
				}
			}
			
			
		}
		
		System.out.println(ans);
	}

}
