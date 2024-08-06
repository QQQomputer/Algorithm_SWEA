package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA1265_D5_달란트2_ver성훈 {
    static long maxVal;
    static int n, p;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= 10; t++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            maxVal = 0;
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
 
            recursion(n, p, 1, 0);
 
            sb.append("#").append(t).append(" ").append(maxVal);
            System.out.println(sb);
        }
    }
 
    public static void recursion(int mod, int quo, long res, int depth) {
        if (depth == p - 1) {
            res *= mod;
            maxVal = Math.max(res, maxVal);
            return;
        }
        System.out.println((mod / quo));
        recursion(mod - (mod / quo), quo - 1, res * (mod / quo), depth + 1);
    }
}