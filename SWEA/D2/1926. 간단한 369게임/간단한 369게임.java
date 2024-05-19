import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int tc = Integer.parseInt(br.readLine().trim());

		// for (int t = 0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); 

			for ( int i = 0; i<n; i++) {
				int num = i+1;

				String num_string = "" + num;

				String cnt369 = "";
				boolean has369 = false;
				for (int j = 0; j<num_string.length(); j++) {
					int num_digit = num_string.charAt(j) - '0';
					if(num_digit == 3 || num_digit == 6 || num_digit == 9) {
						has369 = true;
						cnt369 += "-";
					}
				}

				if (has369) {
					System.out.print(cnt369 + " ");
				}
				else {
					System.out.print(num_string + " ");
				}
			}
			System.out.println();
		// }
	}
}