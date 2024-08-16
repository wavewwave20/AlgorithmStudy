import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int result;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++){  
            br.readLine();
            int [] pwd = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<8; i++) {
                pwd[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 1;
            int index = 0;
            while(true) {
                pwd[index%8] -=cnt++;

                if(pwd[index%8] <= 0) {
                    pwd[index%8] = 0;
                    break;
                }
                if(cnt > 5) {
                    cnt = 1;
                }
                index++;
            }

            index++;
            sb.append("#" + test_case + " ");
            for(int i = 0; i<8; i++) {
                sb.append(pwd[index%8] + " ");
                index++;
            }
            sb.append("\n");
		}
        System.out.println(sb.toString());
	}
}
