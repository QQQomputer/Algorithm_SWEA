package d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8931_D3_제로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K,ans;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			ans=0;
			int idx = 0;
			
			arr = new int[K];
			
			for (int i = 0; i < K; i++) {
				int tmp = Integer.parseInt(br.readLine());
				if(tmp==0) {
					idx--;
					continue;
				}				
				arr[idx++]=tmp;
			}
			
			for (int i = 0; i < idx; i++) {
				ans+=arr[i];
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

