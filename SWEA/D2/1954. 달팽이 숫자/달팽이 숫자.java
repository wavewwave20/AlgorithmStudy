import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= testCases; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int arr[][] = new int[N][N];
			int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };	 //우,하,좌,상
			int count = 1;
			int x = 0, y = 0;
			int d = 0; 
			while (count <= N * N) {
				arr[x][y] = count++;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {  //경계 벗어나거나, 숫자가 이미 존재하면
					d = (d + 1) % 4;  //방향바꿈  
					nx = x + dx[d];
					ny = y + dy[d];
				}
				x = nx;
				y = ny;
			}
			System.out.printf("#%d\n",t);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++)
					System.out.print(arr[r][c] + " ");
				System.out.println();
			}
		}
	}
}