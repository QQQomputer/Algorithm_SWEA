package d3;

import java.util.*;
import java.io.*;

public class Q2817 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, sum, ans;
    public static void main(String args[]) throws Exception
    {
        int T =  Integer.parseInt(br.readLine());
         
        for(int t=1;t<=T;t++){
            ans=0;
            sum=0;
            n= Integer.parseInt(br.readLine());
 
            dfs(1);
             
           //자기자신
            if(n!=1)
                ans++;
 
            System.out.println("#"+t+" "+ans);
        }
 
    }
     
    static void dfs(int depth) {
        if(sum==n){
            ans++;
            return;   
        }else if(sum>n)
            return;   
         
         
        for(int i=depth;i<=(n+1)/2;i++){
            sum+=i;
            dfs(i+1);
            sum-=i;
             
            if(sum>0)
                break;
        }
    }

}
