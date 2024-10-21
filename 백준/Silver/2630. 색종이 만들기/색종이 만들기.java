import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int white,blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int y = 0; y<n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x<n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;

        divide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int row, int col, int size) {
        //종료 조건 : size가 1이거나 모두 같은 색일 때 종료
        if(checkColor(row, col, size)) {
            if(map[row][col] == 0) {
                white++;
            }else {
                blue++;
            }
            return;
        }

        int newSize = size /2;
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
    }

    static boolean checkColor(int row, int col, int size) {
        int color = map[row][col];
        for(int y = row; y<row + size; y++) {
            for(int x = col; x<col + size; x++) {
                if(map[y][x] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}