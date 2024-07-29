package d3;

import java.util.*;
import java.io.*;
//30m 이내 풀음
public class Q1220 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, Nsum, Ssum, ans;
    static int [][] board = new int [100][100];
    public static void main(String args[]) throws IOException
    {
        int T =  10;
         
        for(int t=1;t<=T;t++){
            ans=0;
            Integer.parseInt(br.readLine());
            
            for (int i = 0; i < 100; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
            for (int i = 0; i < 100; i++) {
            	boolean flag = false;
                Nsum=0;
                Ssum=0;
				for (int j = 0; j < 100; j++) {				
					if(board[j][i]==1) {
						if(Nsum>0 && Ssum>0) {
							ans++;
							Nsum=0;
							Ssum=0;
						}
						flag = true;
						Nsum++;
						continue;
					}
					
					if(flag) {
						if(board[j][i]==2)
							Ssum++;
					
					}
				}
				
				if(Nsum>0 && Ssum>0) 
					ans++;
			}
            System.out.println("#"+t+" "+ans);
        }
 
    }
}
