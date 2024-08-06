package d3;

import java.util.Scanner;

//거듭제곱 분할법 사용
public class SWEA1217_D3_거듭제곱_ver성훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 1; t++) {
            int n = sc.nextInt();
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = 1;
            while (b > 0) {
                if (b % 2 == 1) {
                    res *= a;
                }
                a *= a;
                b /= 2;
            }
            System.out.println("#"+n+" "+res);
        }
    }
}
