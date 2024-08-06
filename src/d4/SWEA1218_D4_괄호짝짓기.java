package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//20m
public class SWEA1218_D4_괄호짝짓기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,ans;

	static char [] scs = {'(',')','[',']','{','}','<','>'};
//	Arrays.sort(scs);
//	System.out.println((int)scs[0]);			//최소 40
//	System.out.println((int)scs[scs.length-1]);	//최대 125

	//	()	[]	{}	<>	40~125	=> range 86
	static int [] count = new int[86];
	public static void main(String[] args) throws IOException {
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			count = new int[86];
			ans=1;
			
			for (int i = 0; i < N; i++)
				count[br.read()-40]++;
			br.readLine();//엔터
			
			for (int i = 0; i < 4; i++)
				if(count[scs[i*2]-40] != count[scs[i*2+1]-40])
					ans=0;
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}