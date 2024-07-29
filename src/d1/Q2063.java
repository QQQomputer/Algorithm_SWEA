package d1;

import java.util.Scanner;

public class Q2063 {

	public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int [] array = new int [T];
		
		inputArray(array, sc);
        
		quickSort(array,0,T-1);

//		for(int m = 0;m<=T-1;m++) {
//			System.out.print(array[m]+" ");
//		}
//		
//		System.out.println();
		
        System.out.println(array[T/2]);
        
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long diffTime = (afterTime - beforeTime); // 두 개의 실행 시간
        System.out.println("실행 시간(ms): " + diffTime); // 밀리세컨드(단위 변환)

	}
	
	 
	//array 담기
	static void inputArray(int [] array, Scanner sc) {		
		for(int i=0;i<array.length;i++) {
			array[i]=sc.nextInt();
		}
	}

	//array 퀵 정렬
	static void quickSort(int [] arr, int l, int r) {		
		if(l < r) {
			int p = partition(arr, l, r);
			
			quickSort(arr, l, p-1);
			quickSort(arr, p, r);
		}
	}
	
	//	작은 수 < 피벗 < 큰 수 
	static int partition(int [] arr, int l, int r) {
//		 System.out.println(" l : "+l+" r : "+r );
//		 
//		 for(int m = l;m<=r;m++) {
//			 System.out.print(arr[m]+" ");
//		 }

		int pivot = arr[r];
		
		int i = l-1;
		
		for(int j=l;j<=r-1;j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr,i,j);
			}
		}

		swap(arr,i+1,r);
		
		return i+1;
	}
	
	//값 교체
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
