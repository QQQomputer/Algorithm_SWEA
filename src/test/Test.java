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
			int[] a=new int[] {2,5,3,7,9,13,1,4,8,10};
			int [] c=new int[a.length];
			int[] d=Arrays.copyOf(a, a.length);
			System.arraycopy(a, 0, c, 0, a.length);
			int[] e=a.clone(); 
			// 계산후 옛날것과 비교
			d[0]=-1;
			System.out.println(Arrays.equals(a, d));
			
			// 얕은 복사
			int [] b=a;
			b[0]=-200;
			System.out.println(Arrays.equals(a, b));
			int[] f=new int[100];
			Arrays.fill(f, -1);
			System.out.println(Arrays.toString(f));
			Arrays.sort(a);// ASC
			
			int[][] ee=new int[10][10];
			for (int i = 0; i < 10; i++) {
				Arrays.fill(ee[i], -5);
			}
			int[][] ef=new int[10][10];
			for (int i = 0; i < 10; i++) {
				System.arraycopy(ee[i], 0, ef[i], 0, 10);
			}
			System.out.println(Arrays.toString(a));
			int index1=Arrays.binarySearch(a,  10);
			int index2=Arrays.binarySearch(a,  11);
			System.out.println(index1);
			System.out.println(index2);  //-10 -index2-1 9
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
