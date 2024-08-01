package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA20019_회문의회문 {
	static int T;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());		
		boolean flag;
		for (int t = 1; t <= T; t++) {
			str = br.readLine();
			flag=true;
			
			int last = str.length()-1;

			//전체 회문
			//(0,str.length()-1)
			if(!palindrome(0,last))
				flag=false;

			//왼쪽 회문
			//(0,(str.length()-1)/2-1)
			if(!palindrome(0,last/2-1))
				flag=false;

			//오른쪽 회문
			//(str.length()-1-((str.length()-1)/2+1,str.length()-1)
			if(!palindrome(last-last/2+1,last))
				flag=false;
			
			if(flag)
				sb.append("#").append(t).append(" ").append("YES").append("\n");
			else
				sb.append("#").append(t).append(" ").append("NO").append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static boolean palindrome(int l, int r) {		
		System.out.println(l+", "+r);
		while(l<r) {
			if(str.charAt(l)!=str.charAt(r))
				return false;
			l++;
			r--;			
		}
		
		return true;
	}
}
