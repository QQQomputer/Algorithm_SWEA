package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    
    static int T = 0;
    static int N = 100;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,0,0};
    static int[] dc = {0,1,-1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int t=1;t <=1; t++){
            T = Integer.parseInt(br.readLine());
            
            int end = 0;
            arr = new int[N][N];
            visited = new boolean[N][N];
            
            for(int i=0;i<N;i++) {
                st =  new StringTokenizer(br.readLine());
                for (int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st .nextToken());
                    if (arr[99][j]==2) {
                        end = j;
                    }
                }
            }
            
            int row = 99;
            int col = end;
            
            while(row > 0) {
                for (int i=0;i<3; i++) {
                    int r = dr[i] + row;
                    int c = dc[i] + col;
                    
                       if (check(r,c) && visited[r][c] == false && arr[r][c] == 1 & i == 1) {
                        col += 1;
                        visited[r][c] = true;
                    }else if (check(r,c) && visited[r][c] == false && arr[r][c] == 1 & i == 2) {
                        col -= 1;
                        visited[r][c] = true;
                    }else if (check(r,c) && visited[r][c] == false && arr[r][c] == 1 & i == 0) {
                        row -= 1;
                        visited[r][c] = true;
                    }                
                }
            }
            System.out.printf("#%d %d",t,col);
        }
    }
    
    public static boolean check(int r, int c) {
        if(r >= 0 && r <= N-1 && c >= 0 && c <= N-1) {
            return true;
        }
        else {
            return false;
        }
    }
}    