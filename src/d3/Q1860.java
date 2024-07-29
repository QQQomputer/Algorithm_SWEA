package d3;

import java.util.*;
import java.io.*;

public class Q1860 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,k, sum;
    static boolean flag;
    static int [] sumArr;
    public static void main(String args[]) throws IOException
    {
        int T =  Integer.parseInt(br.readLine());
         
        for(int t=1;t<=T;t++){
        	sumArr = new int[11112];
            sum=0;
            flag =true;
        	
            st = new StringTokenizer(br.readLine());            
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());   
            for (int i = 0; i < n; i++)
            	sumArr[Integer.parseInt(st.nextToken())]++;
			

            for (int i = 1; i < sumArr.length; i++) {
            	sum+=sumArr[i];
            	if(k *(i/m)<sum) { 
            		flag=false;
            		break;
            	}
			}
            
            if(flag)
            	sb.append("#"+t+" Possible\n");
            else
            	sb.append("#"+t+" Impossible\n");
            
        }
        System.out.println(sb.toString()); 
    }
}
