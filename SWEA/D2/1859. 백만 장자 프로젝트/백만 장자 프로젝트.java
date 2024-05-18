import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		long[] answer = new long[testCases];
		
		for (int T = 0; T<testCases; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] price = new int[N];
			int max_value = 0;
			long ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = N-1; j>=0; j--) {
				if(price[j]>max_value) {
					max_value = price[j];
				}
				ans += max_value - price[j];
			}
			answer[T] = ans;
		}
		for (int T = 0; T<testCases; T++) {
			System.out.print("#" + (T+1) + " " + answer[T] + "\n");
		}
	}
}