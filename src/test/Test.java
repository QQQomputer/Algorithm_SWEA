package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
public class Test {
	
	


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt();

	        for (int t = 1; t <= T; t++) {
	            int n = scanner.nextInt();
	            int cnt = 0, sum = 0;

	            for (int i = 1; i <= n; i++) {
	                sum += i;
	                int n1 = n - sum;
	                if (n1 < 0) {
	                    break;
	                }
	                if (n1 % i == 0) {
	                    cnt++;
	                }
	            }
	            System.out.println("#" + t + " " + cnt);
	        }

	        scanner.close();
	    }
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static int [] arr;
//	public static void main(String[] args) throws Exception {
//
//        StringBuilder sb = new StringBuilder();
//
//        int [] a = new int[10];
//        
//        System.out.println(a[0]);
//		
//		
//		bw.flush();
//		bw.close();
//		br.close();
//
//	}
    public static int readInt() throws IOException {
		int result = 0;
        Boolean negative = false;
        int read = br.read();
        
        while(read < '0' || read > '9'){
        	if (read == '-')
                negative = true;
            
            read = br.read();
        }
        
        result = read -'0';
        
//        while(read >= '0' && read <= '9'){
//         	result = result * 10 + (read -'0');
//            read = br.read();
//        }
        
        return negative ? -result : result;
    }
    

    static void swap(int a, int b){
        int tmp=arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
