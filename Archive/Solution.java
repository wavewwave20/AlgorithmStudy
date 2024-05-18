package Archive;


import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		long[] answer = new long[testCases];
		
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		
		for (int T = 0; T<testCases; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int cnt = 1;
			
			
			while (cnt > N) {
				
			}
			
			
			
			
			
			
		}
		for (int T = 0; T<testCases; T++) {
			System.out.print("#" + (T+1) + " " + answer[T] + "\n");
		}
	}
}