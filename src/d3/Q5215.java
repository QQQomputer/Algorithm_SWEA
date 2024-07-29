package d3;

import java.util.*;
import java.io.*;
 
public class Q5215
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans, n, l, sumCal, sumPoint;
    static int [] point = new int[20];
    static int [] calorie = new int[20];
    static String str;
    public static void main(String args[]) throws Exception
    {
        int T = readInt();
        for(int t = 1;t<=T;t++){
            n = readInt();
            l = readInt();
             
            ans=0;
            sumCal=0;
             
            for(int i=0;i<n;i++){
                point[i] = readInt();
                calorie[i] = readInt();
            }
 
            dfs(0);
             
            System.out.println("#"+t+" "+ ans);
        }
         
    }
     
    static void dfs(int depth) throws IOException{     
        if(sumCal > l){
            ans = Math.max(sumPoint-point[depth-1],ans);
            return;
        }else if(depth >= n){
            ans = Math.max(sumPoint,ans);
            return;
        }
              
        for(int i =depth;i<n;i++){
            sumCal += calorie[i];
            sumPoint+=point[i];
            dfs(i+1);
            sumCal -= calorie[i];
            sumPoint-=point[i];
        } 
    }
     
    static int readInt() throws IOException {
        int result = 0;
        int read = br.read();
         
        while(read <'0' || read >'9')
            read = br.read();
         
        while(read >= '0' && read <= '9'){
            result = result * 10 + read -'0';
            read = br.read();
        }
         
        return result;
    }
}